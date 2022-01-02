package com.example.project1.Events;

import java.time.LocalTime;

public class PriceSettingEvent extends Event {

    private String captainName;
    private int price;

    public PriceSettingEvent(String captainName, int price) {
        super.eventName = "PriceSetting";
        super.eventTime = LocalTime.now();
        this.captainName = captainName;
        this.price = price;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
