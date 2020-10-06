package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.exception.ServiceException;
import com.lti.repository.AccountRepository;
import com.lti.repository.AccountStatement;
import com.lti.repository.TransactionRepository;
@Service
public class AccountStatementServiceImpl implements AccountStatementService{
  @Autowired
  private AccountStatement accountStatement;
  @Autowired
  private AccountRepository accountRepository;
  
  public List<Transaction> accountStatment(int userId){
	  Account acc = (Account) accountRepository.fetchAccountsByUserId( userId);
	  try {
		List<Transaction> transactions = accountStatement.getAllRecords(acc.getAccountNumber());
		return transactions;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new ServiceException("Error occured while fetching transactions");
	}
	  
  }

@Override
public List<Transaction> accountHistory(int userId) {
	Account acc = (Account) accountRepository.fetchAccountsByUserId(userId);
	try {
		List<Transaction> transactions = accountStatement.getAccountHistory(acc.getAccountNumber());
		return transactions;
	} catch (Exception e) {
		throw new ServiceException("Error occured while fetching transactions");
	}
}
  
  
}	 
	  
  




