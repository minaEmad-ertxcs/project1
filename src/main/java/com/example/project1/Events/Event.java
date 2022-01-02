package com.example.project1.Events;
import java.time.LocalTime;

public class Event {

    protected String eventName;
    protected LocalTime eventTime;

    public Event() {
        eventName = " ";
        eventTime = LocalTime.now();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }
}
