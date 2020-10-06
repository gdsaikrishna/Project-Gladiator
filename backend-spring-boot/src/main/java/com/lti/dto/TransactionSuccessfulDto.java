package com.lti.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.lti.entity.Transaction;

public class TransactionSuccessfulDto extends Status{
	
	private TransactionSuccessDto transactionSuccessDto;

	public TransactionSuccessDto getTransactionSuccessDto() {
		return transactionSuccessDto;
	}

	public void setTransactionSuccessDto(TransactionSuccessDto transactionSuccessDto) {
		this.transactionSuccessDto = transactionSuccessDto;
	}
	
	
	

}
