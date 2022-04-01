package com.cg.farmstore.dto;

import com.cg.farmstore.entities.UserType;

public class CredentialPojo {

	private String userName;
	private String password;
	private UserType userType;

	public CredentialPojo() {
		super();
	}

	public CredentialPojo(String userName, String password, UserType userType) {
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

}
