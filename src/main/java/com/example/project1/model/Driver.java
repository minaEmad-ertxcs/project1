package com.example.project1.model;

import java.util.ArrayList;

public class Driver extends Person {

    private String license;
    private String nationalID;
    private double avgRating;
    private ArrayList<String> favoriteAreas = new ArrayList<>();
    private int numberOfSeats;
    private boolean available = true;

    public Driver() {
    }

    public Driver(Driver driver) {
        this.userName = driver.userName;
        this.email = driver.email;
        this.mobNumber = driver.mobNumber;
        this.password = driver.password;
        this.license = driver.license;
        this.nationalID = driver.nationalID;
        this.avgRating = driver.avgRating;
        this.favoriteAreas = driver.favoriteAreas;
        this.numberOfSeats = driver.numberOfSeats;
        this.available = driver.available;
    }

    public Driver(String userName, String mobNumber, String email, String password, String license, String nationalID) {
        this.userName = userName;
        this.mobNumber = mobNumber;
        this.email = email;
        this.password = password;
        this.license = license;
        this.nationalID = nationalID;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avg) {
        this.avgRating = avg;
    }

    public String getDriverInfo() {
        return this.getUserName() + "," + this.getMobNumber() + "," + this.getEmail() + "," + this.getNationalID() + "," + this.getLicense() + "," + this.getAvgRating();
    }

    public String getLicense() {
        return license;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    public void setFavoriteAreas(ArrayList<String> favoriteAreas) {
        this.favoriteAreas = favoriteAreas;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSites) {
        this.numberOfSeats = numberOfSites;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
