package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

import com.lti.entity.Transaction;

public interface AccountStatement extends GenericRepository {
	
	public List<Transaction> getAccountHistory(int accNumber);
	public List<Transaction> getAllRecords(int accountNumber, LocalDate fromDate, LocalDate toDate);

}
