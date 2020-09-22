package com.lti.entity;

import java.time.LocalDateTime;

public class Transaction {
	
	private int transactionId;
	private int debitAccountNumber; //FK
	private int creditAccountNumber; //FK
	private double amount;
	private String transactionType;
	private String remarks;
	private LocalDateTime transactionDateTime;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getDebitAccountNumber() {
		return debitAccountNumber;
	}
	public void setDebitAccountNumber(int debitAccountNumber) {
		this.debitAccountNumber = debitAccountNumber;
	}
	public int getCreditAccountNumber() {
		return creditAccountNumber;
	}
	public void setCreditAccountNumber(int creditAccountNumber) {
		this.creditAccountNumber = creditAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	
}
