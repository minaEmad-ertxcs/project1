package com.example.project1;


import java.util.ArrayList;
import java.util.Arrays;

import com.example.project1.Events.Event;
import com.example.project1.Services.*;
import com.example.project1.model.User;

public class SystemMemory {

    public static ArrayList<UserService> users = new ArrayList<>();
    public static ArrayList<DriverService> drivers = new ArrayList<>();
    public static ArrayList<Request> requests = new ArrayList<>();
    public static ArrayList<Event> events = new ArrayList<>();
    public static ArrayList<String> publicHoliday = new ArrayList<>(Arrays.asList("25-01", "06-10", "30-06", "01-05"));

    public SystemMemory() {
    }

    public static void addUser(UserService u) {
        users.add(u);
    }

    public static void addDriver(DriverService d) {
        drivers.add(d);
    }

    public static void addRequests(Request r) {
        requests.add(r);
    }

    public static void deleteUser(UserService u) {
        users.remove(u);
    }

    public static void deleteDriver(DriverService d) {
        drivers.remove(d);
    }

    public static void addEvent(Event e) {
        events.add(e);
    }

    public static ArrayList<String> getDrivers() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < drivers.size(); i++) {
            //System.out.println("Driver " + (i + 1) + " : " + drivers.get(i).getDriver());
            result.add("Driver " + (i + 1) + " : " + drivers.get(i).getDriver());
        }
        return result;
    }

    public static ArrayList<UserService> getUsers() {
        ArrayList<UserService> result = new ArrayList<>();
        /*for (int i = 0; i < users.size(); i++) {
            //System.out.println("User " + (i + 1) + " : " + users.get(i).getUser());
            result.add("User " + (i + 1) + " : " + users.get(i).getUser());
        }*/
        for (UserService user : users) {
            //System.out.println("User " + (i + 1) + " : " + users.get(i).getUser());
            result.add(user);
        }
        return result;
    }
}
