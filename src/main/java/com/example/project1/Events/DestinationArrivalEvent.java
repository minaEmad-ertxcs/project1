package com.example.project1.Events;

import java.time.LocalTime;

public class DestinationArrivalEvent extends Event {
    String captainName;
    String userName;

    public DestinationArrivalEvent(String userName, String captainName) {
        super.eventName = "DestinationArrival";
        super.eventTime = LocalTime.now();
        this.captainName = captainName;
        this.userName = userName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
