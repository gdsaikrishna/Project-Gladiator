package com.lti.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.Transaction;

public class TransactionSuccessfulDto extends Status{
	
	private Transaction transaction;

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	
	

}
