package com.cg.farmstore.entities;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String userName;
	private String password;
	private UserType userType;

	// need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public JwtRequest(String userName, String password, UserType userType) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "JwtRequest [userName=" + userName + ", password=" + password + ",  userType=" + userType + "]";
	}

}
