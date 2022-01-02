package com.example.project1.Services;

import com.example.project1.model.Driver;
import com.example.project1.SystemMemory;
import com.example.project1.Events.PriceSettingEvent;


public class DriverService implements Signup<Driver>, Login, Observer {

    private Driver driver;
    private Request request;
    private Rating rating;

    @Override
    public boolean login(String username, String password) {
        //return username.equals(driver.getUserName()) && password.equals(driver.getPassword());
        for (int i = 0; i < SystemMemory.drivers.size(); i++) {
            DriverService d = SystemMemory.drivers.get(i);
            if (d.getDriver().getUserName().equals(username) && d.getDriver().getPassword().equals(password)) {
                this.request = new Request();
                this.request.subscribe(this);
                return true;
            }
        }
        return false;
    }

    @Override
    public void signUp(Driver driver) {
        this.driver = new Driver(driver);
        this.rating = new Rating();
        AdminService.ListOfDrivers.add(this);
    }

    /*public void ShowAllRequests() {
        System.out.println("For Driver : " + driver.getUserName());
        for (int i = 0; i < Request.allRequests.size(); i++) {
            for (int j = 0; j < driver.getFavoriteAraes().size(); j++) {
                if (Request.allRequests.get(i).getSource().equalsIgnoreCase(driver.getFavoriteAraes().get(j))) {
                    System.out.println("The Request " + (i + 1) + " : " + Request.allRequests.get(i).getTheRequest());

                }
            }
        }
    }*/

    public void addFavoriteArea(String area) {
        driver.getFavoriteAreas().add(area);
    }

    public void showAllFavoriteArea() {
        System.out.println(driver.getFavoriteAreas());
    }

    public void selectRequest(int numOfRequest, int price) {
        this.request = Request.allRequests.get(numOfRequest - 1);
        this.request.setPrice(price);
        this.request.rideEvent.getEvents().add(new PriceSettingEvent(driver.getUserName(), this.request.getPrice()));
        this.request.setIsTaken(true);
        //this.request.getDriverService().setDriver(driver);
        this.request.setDriverService(this);
        /*Request.allRequests.remove(Request.allRequests.get(numOfRequest - 1));*/
        // Request.allRequests.remove(this.request);
    }

    public String showSelectedRequest() {
        if (this.request.isAccept()) {
            return "The price accepted by user " + this.request.getUserService().getUser().getUserName();
        } else {
            return "The user didn't accept the price and the request canceled";
        }
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String update() {
        String msg = "";
        for (int i = 0; i < Request.allRequests.size(); i++) {
            for (int j = 0; j < driver.getFavoriteAreas().size(); j++) {//nafs alsourse area wa available wa numofsites mkafeeeeeeeea

                if (Request.allRequests.get(i).getSource().equalsIgnoreCase(driver.getFavoriteAreas().get(j))
                        && driver.isAvailable()
                        && driver.getNumberOfSeats() >= Request.allRequests.get(i).getNumOfPeople()) {
                    //System.out.println("For Driver : " + driver.getUserName() + "has new notification : The Request " + (i + 1) + " : " + Request.allRequests.get(i).getTheRequest());
                    msg = "The Request " + (i + 1) + " : " + Request.allRequests.get(i).getTheRequest();
                }
            }
        }
        if (msg.equals("")) {
            msg = "There is no notifications for you, " + driver.getUserName();
        } else {
            msg = "For Driver : " + driver.getUserName() + " has new notification : " + msg;
        }
        return msg;
    }
}
