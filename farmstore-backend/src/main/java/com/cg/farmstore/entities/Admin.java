package com.cg.farmstore.entities;

public class Admin {

	private String userName = "farmstore_admin";
	private String password = "password";
	private UserType userType = UserType.ADMIN;

	public Admin() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public UserType getUserType() {
		return userType;
	}

}
