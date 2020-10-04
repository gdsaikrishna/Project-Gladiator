package com.lti.dto;

public class AccountSummaryStatus extends Status {

	private int accountNumber;
	private double balance;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAcccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
