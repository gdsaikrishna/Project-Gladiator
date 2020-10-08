package com.lti.dto;

public class ForgotPasswordStatus extends Status {

	public boolean userExists;

	public boolean isUserExists() {
		return userExists;
	}
	public void setUserExists(boolean userExists) {
		this.userExists = userExists;
	}
}
