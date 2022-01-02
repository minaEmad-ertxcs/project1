package com.example.project1.Services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import com.example.project1.model.*;
import com.example.project1.Events.RideEvent;
import com.example.project1.*;

@Component
public class AdminService implements Login {
    private Admin admin;
    public ArrayList<UserService> suspendesListOfUser = new ArrayList<>();
    public ArrayList<DriverService> suspendesListOfDriver = new ArrayList<>();
    public static ArrayList<DriverService> ListOfDrivers = new ArrayList<>();
    public static ArrayList<RideEvent> rideEvents = new ArrayList<>();
    public static ArrayList<String> specificAreas = new ArrayList<>(Arrays.asList("haram", "fasel", "shobra", "zaton"));


    @Override
    public boolean login(String username, String password) {
        return username.equals(admin.getUserName()) && password.equals(admin.getPassword());
    }

    public boolean checkDriverInfo(Driver driver) {
        return !driver.getLicense().equals("") && !driver.getNationalID().equals("");
    }

    public void selectDriver(int index) {
        DriverService d = ListOfDrivers.get(index - 1);
        ListOfDrivers.remove(index - 1);
        SystemMemory.addDriver(d);
        //Request.observersList.add(d);
    }

    public ArrayList<String> listPendingDriverRegistrations() {
        /*for (int i = 0; i < ListOfDrivers.size(); i++) {
            System.out.println("Driver " + (i + 1) + " : " + ListOfDrivers.get(i).getDriver().getUserName());
        }*/
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < ListOfDrivers.size(); i++) {
            result.add("Driver " + (i + 1) + " : " + ListOfDrivers.get(i).getDriver().getUserName());
        }
        return result;
    }

    public void suspendUser(UserService u) {
        SystemMemory.deleteUser(u);
        suspendesListOfUser.add(u);
    }

    public void suspendDriver(DriverService d) {
        SystemMemory.deleteDriver(d);
        suspendesListOfDriver.add(d);
    }

    public ArrayList<String> showListOfSuspended() {
        ArrayList<String> result = new ArrayList<>();
        /*System.out.println("Drivers : ");
        for (DriverService driver : suspendesListOfDriver) {
            System.out.println(driver.getDriver());
        }
        System.out.println("User : ");
        for (UserService user : suspendesListOfUser) {
            System.out.println(user.getUser());
        }*/
        result.add("Drivers : ");
        for (DriverService driver : suspendesListOfDriver) {
            result.add(driver.getDriver().getDriverInfo());
        }
        System.out.println("User : ");
        for (UserService user : suspendesListOfUser) {
            result.add(user.getUser().getUser());
        }
        return result;
    }

    public static ArrayList<String> getSpecificAreas() {
        return specificAreas;
    }

    public static void setSpecificAreas(ArrayList<String> specificAreas) {
        AdminService.specificAreas = specificAreas;
    }
}
