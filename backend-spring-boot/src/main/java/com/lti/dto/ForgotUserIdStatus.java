package com.lti.dto;

public class ForgotUserIdStatus extends Status {

	private boolean accountExists;
	private int userId;

	public boolean isAccountExists() {
		return accountExists;
	}
	public void setAccountExists(boolean accountExists) {
		this.accountExists = accountExists;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
