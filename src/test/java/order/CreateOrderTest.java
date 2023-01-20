package order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.example.order.Order;
import org.example.order.OrderChecks;
import org.example.order.OrderClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;


@RunWith(Parameterized.class)

public class CreateOrderTest {
    private final OrderClient data = new OrderClient();
    private final OrderChecks checks = new OrderChecks();
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final int rentTime;
    private final String deliveryDate;
    private final String comment;
    private final List color;

    public CreateOrderTest(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, List color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] colorOfScooter(){
        return new Object[][]{
                { "Баффи", "Саммерз", "Ленина, 21", "5", "89244778376", 5, "2023-03-03", "Будьте здоровы!", Arrays.asList("BLACK")},
                { "Чиполлино", "Петров", "Огородная, 22", "6", "89148368494", 2, "2023-03-04", "Лук полезный, но меня не жрите!", Arrays.asList("GREY")},
                { "Чебурашка", "Чебурахов", "Чебураховская, 5", "5", "89645676543", 7, "2023-02-07", "Давайте быстрее, пока я не чебурахнулся!", Arrays.asList("BLACK", "GREY")},
                { "Вова", "Холстинин", "Есенина, 12", "6", "89244778787", 1, "2023-04-03", "Лишь бы гриф не прогнулся.", Arrays.asList("")},
        };
    }

    @Test
    @DisplayName("Creation order")
    @Description("Проверим, что когда создаёшь заказ:\n" +
            "можно указать один из цветов — BLACK или GREY;\n" +
            "можно указать оба цвета;\n" +
            "можно совсем не указывать цвет;\n" +
            "тело ответа содержит track.")

    public void orderCreation(){
        Order order = new Order(firstName, lastName, address, metroStation, phone, rentTime, deliveryDate, comment, color);
        Response response = data.create(order);
        checks.orderCreatedSuccessfully(response);
    }
}
