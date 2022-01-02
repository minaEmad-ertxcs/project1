package com.example.project1.Services;

import java.util.ArrayList;
import com.example.project1.Discount.*;
import com.example.project1.Events.RideEvent;

public class Request implements Subject {

    private String Source, dest;
    private int numOfPeople;

    private UserService userService;
    private DriverService driverService;
    private Rating rating;
    private Discount discount;

    private int price;
    private boolean isTaken = false;//ignored now
    private boolean accept = false;
    private static int numberOfObjects;
    public static ArrayList<Request> allRequests = new ArrayList<>();
    public RideEvent rideEvent = new RideEvent();
    public static ArrayList<Observer> observersList = new ArrayList<>();

    public boolean isTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public Request() {
        numberOfObjects++;
    }

    public void makeRequest(String source, String dest, int numOfPeople, UserService userService) {
        this.Source = source;
        this.dest = dest;
        this.numOfPeople = numOfPeople;
        this.userService = userService;
        allRequests.add(this);
        notifyAllSubscribers();
    }

    public String getTheRequest() {
        return "the sourse is " + this.Source + " and the dest is " + this.dest
                + " and the user's name is : " + this.userService.getUser().getUserName();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSource() {
        return Source;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public DriverService getDriverService() {
        return driverService;
    }

    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    public Rating getRating() {
        return rating;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    @Override
    public void subscribe(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observersList.remove(observer);
    }

    @Override
    public ArrayList<String> notifyAllSubscribers() {
        ArrayList<String> result = new ArrayList<>();
        for (Observer observer : observersList) {
            //System.out.println(observer.update());
            result.add(observer.update());
        }
        return result;
    }

    public String getDest() {
        return dest;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
