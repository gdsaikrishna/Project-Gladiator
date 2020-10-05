package com.lti.service;

import com.lti.dto.TransactionDto;
import com.lti.entity.Account;
import com.lti.entity.Transaction;

public interface TransactionService {
	
	public Transaction fundTransfer(TransactionDto transactionDto);
	public void debit(Account account,double amount);
	public void credit(Account account,double amount);

}
