package com.lti.service;

import com.lti.dto.TransactionDto;
import com.lti.entity.Account;

public interface TransactionService {
	
	public void fundTransfer(TransactionDto transactionDto);
	public void debit(Account account,double amount);
	public void credit(Account account,double amount);

}
