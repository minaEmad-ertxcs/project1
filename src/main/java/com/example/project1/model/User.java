package com.example.project1.model;

import java.time.LocalDate;

public class User extends Person {

    private LocalDate birthDate;
    private boolean firstTime;

    public String getUser() {
        return this.userName + "," + this.mobNumber + "," + this.email;
    }

    public User() {
    }

    public User(User user) {
        this.userName = user.userName;
        this.email = user.email;
        this.mobNumber = user.mobNumber;
        this.password = user.password;
        this.firstTime = user.firstTime;
        this.birthDate = user.birthDate;
    }

    public User(String name, String mobNumber, String email, String password) {
        this.userName = name;
        this.mobNumber = mobNumber;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }
}
