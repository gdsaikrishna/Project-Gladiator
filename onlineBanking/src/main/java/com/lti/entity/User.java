package com.lti.entity;

public class User {
	
	private int id;
	//private Customer customer;//fk
	private String UserPassword;
	private String TransactionPassword;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getTransactionPassword() {
		return TransactionPassword;
	}
	public void setTransactionPassword(String transactionPassword) {
		TransactionPassword = transactionPassword;
	}
	
	

}
