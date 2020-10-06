package com.lti.service;

import java.util.List;

import com.lti.entity.Transaction;

public interface AccountStatementService {
	
	public List<Transaction> accountStatment(int userId);
	public List<Transaction> accountHistory(int userId);

}
