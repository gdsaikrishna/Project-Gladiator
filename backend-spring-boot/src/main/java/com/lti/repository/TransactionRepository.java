package com.lti.repository;


import com.lti.entity.Transaction;

public interface TransactionRepository extends GenericRepository{
	
	public Transaction fetchTransactionObjectAfterSaving(Transaction transaction);
	
	
}
