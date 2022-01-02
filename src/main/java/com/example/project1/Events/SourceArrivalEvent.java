package com.example.project1.Events;

import java.time.LocalTime;

public class SourceArrivalEvent extends Event {
    private String captainName;
    private String userName;

    public SourceArrivalEvent(String userName, String captainName) {
        super.eventName = "SourceArrival";
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
