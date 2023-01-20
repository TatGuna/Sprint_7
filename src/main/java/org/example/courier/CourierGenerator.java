package org.example.courier;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {

    public Courier generic(){
        return new Courier("Buffy13", "1235", "Summers13");
    }
    public Courier random(){
        return new Courier(RandomStringUtils.randomAlphanumeric(10),"1235", "Summers13");
    }
    public Courier loginData(){
        return new Courier("Buffy13","1235");
    }
}
