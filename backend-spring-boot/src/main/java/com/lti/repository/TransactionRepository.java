package com.lti.repository;

import java.util.List;

import com.lti.entity.Transaction;

public interface TransactionRepository {
	
	boolean isTransactionPresent();
	void save(Transaction transaction);
	int getTranactionId();
	List<Transaction> getTransactionBetweenDates(String fromDate, String toDate, String accountNumber);
	void getTransactionId();
	
	
}
