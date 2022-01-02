package com.example.project1.Services;

import java.util.ArrayList;

public interface Subject {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    ArrayList<String> notifyAllSubscribers();
}