package com.lti.repository;

import java.util.List;

import com.lti.entity.Transaction;

public interface TransactionRepository extends GenericRepository{
	
	public Transaction fetchTransactionObjectAfterSaving(Transaction transaction);
	
	
}
