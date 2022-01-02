package com.example.project1.Events;

import java.time.LocalTime;

public class PriceAcceptanceEvent extends Event {
    private String userName;

    public PriceAcceptanceEvent(String userName) {
        super.eventName = "PriceAcceptance";
        super.eventTime = LocalTime.now();
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
