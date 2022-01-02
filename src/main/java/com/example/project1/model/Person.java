package com.example.project1.model;

public abstract class Person{

    protected String userName;
    protected String mobNumber;
    protected String email;
    protected String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
