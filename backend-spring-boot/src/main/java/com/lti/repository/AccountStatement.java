package com.lti.repository;

import java.util.List;

import com.lti.entity.Transaction;

public interface AccountStatement extends GenericRepository {
	
	public List<Transaction> getAllRecords(int accNumber);

}
