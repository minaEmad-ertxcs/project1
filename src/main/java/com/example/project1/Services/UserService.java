package com.example.project1.Services;

import com.example.project1.SystemMemory;
import com.example.project1.model.User;
import com.example.project1.Events.*;
import com.example.project1.Discount.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UserService implements Signup<User>, Login {

    private User user;
    private Request request;
    private LocalDate date = LocalDate.now();
    private DateTimeFormatter nonFullFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public boolean login(String username, String password) {
        for (int i = 0; i < SystemMemory.users.size(); i++) {
            UserService u = SystemMemory.users.get(i);
            if (u.getUser().getUserName().equals(username) && u.getUser().getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User signUp(User user) {
        this.user = new User(user);
        this.user.setFirstTime(true);
        SystemMemory.addUser(this);
        return user;
    }

    public String askForRequest(String source, String dest, int numOfPeople) {
        request = new Request();
        request.makeRequest(source, dest, numOfPeople, this);
        return "Created Request";
    }

    public String showMyRequest() {
        String result = "";
        if (this.request != null) {
            if (request.isTaken()) {
                int thePrice = request.getPrice();
                int afterDiscount = checkDiscount(thePrice);

                if (request.getPrice() != afterDiscount) {
                    /*System.out.println(user.getName() + ", your request is accepted and the ride will cost " + request.getPrice()
                            + " before the discount and will cost " + afterDiscount + " after the dicount by driver "
                            + this.request.getDriverService().getDriver().getUserName());*/
                    result = user.getName() + ", your request is accepted and the ride will cost " + request.getPrice()
                            + " before the discount and will cost " + afterDiscount + " after the dicount by driver "
                            + this.request.getDriverService().getDriver().getUserName();
                } else {
                    /*System.out.println(user.getName() + ", your request is accepted and the ride will cost " + request.getPrice()
                            + " by Driver " + this.request.getDriverService().getDriver().getUserName());*/
                    result = user.getName() + ", your request is accepted and the ride will cost " + request.getPrice()
                            + " by Driver " + this.request.getDriverService().getDriver().getUserName();
                }
                this.request.rideEvent.getEvents().add(new PriceAcceptanceEvent(user.getName()));
                this.request.rideEvent.getEvents().add(new SourceArrivalEvent(this.request.getUserService().getUser().getName(), this.request.getDriverService().getDriver().getUserName()));
            }
        } else {
            //System.out.println("sorry " + user.getName() + " you request is not accepted yet, please wait");
            result = "sorry " + user.getName() + " you request is not accepted yet, please wait";
        }
        return result;
    }

    public int checkDiscount(int afterDiscount) {

        if (AdminService.getSpecificAreas().contains(request.getDest().toLowerCase())) {
            this.request.setDiscount(new SpecialDestinationAreaDiscount());
            afterDiscount = this.request.getDiscount().discount(afterDiscount);
        }
        if (this.request.getNumOfPeople() >= 2) {
            this.request.setDiscount(new TwoPassengersDiscount());
            afterDiscount = this.request.getDiscount().discount(afterDiscount);
        }
        if (date.format(nonFullFormatter).equals(getUser().getBirthDate().format(nonFullFormatter))) {
            this.request.setDiscount(new BirthDateDiscount());
            afterDiscount = this.request.getDiscount().discount(afterDiscount);
        }
        if (SystemMemory.publicHoliday.contains(date.format(nonFullFormatter))) {
            this.request.setDiscount(new PublicHolidayDiscount());
            afterDiscount = this.request.getDiscount().discount(afterDiscount);
        }
        if (user.isFirstTime()) {
            this.request.setDiscount(new FirstRideDiscount());
            afterDiscount = this.request.getDiscount().discount(afterDiscount);
        }
        return afterDiscount;
    }

    public void makeYourChoice(boolean choice) {
        if (choice) {
            this.request.rideEvent.getEvents().add(new PriceAcceptanceEvent(user.getName()));
            this.request.rideEvent.getEvents().add(new SourceArrivalEvent(this.request.getUserService().getUser().getName(), this.request.getDriverService().getDriver().getUserName()));
            this.request.setAccept(true);
            this.request.getDriverService().getDriver().setAvailable(false);
            Request.allRequests.remove(this.request);
        } else {
            this.request.setAccept(false);
        }
    }

    public String rateDriver(double rate) {
        String result = "";
        if (this.request != null) {
            if (request.isTaken()) {
                request.getDriverService().getRating().setRate(rate);
                request.rideEvent.getEvents().add(new DestinationArrivalEvent(user.getName(), request.getDriverService().getDriver().getUserName()));
                //System.out.println(this.user.getName() + ", your rate is " + rate + " to the driver " + this.request.getDriverService().getDriver().userName);
                result = this.user.getName() + ", your rate is " + rate + " to the driver " + this.request.getDriverService().getDriver().getUserName();
                request.getDriverService().getDriver().setAvgRating(request.getDriverService().getRating().getAverage());
                AdminService.rideEvents.add(request.rideEvent);
                Request.allRequests.remove(this.request);
                request.getDriverService().getDriver().setAvailable(true);
                user.setFirstTime(false);
                request = null;

            } else {
                //System.out.println("sorry " + user.getName() + " you request is not accepted yet and you can't rate, please wait");
                result = "sorry " + user.getName() + " you request is not accepted yet and you can't rate, please wait";
            }
        }
        return result;
    }

    public User getUser() {
        return user;
    }

    public UserService getUserById(int index) {
        return SystemMemory.getUsers().get(index);
    }

    public void setUser(User user) {
        this.user = user;
    }

}
