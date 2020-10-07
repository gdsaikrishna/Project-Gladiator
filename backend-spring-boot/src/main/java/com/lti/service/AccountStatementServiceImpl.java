package com.lti.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.dto.StatementTransactionDto;
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
  private AccountRepository accountRepository;
  
  
  @Override
  
  public  List<StatementTransactionDto> accountStatment(int userId){
	  Account acc = (Account) accountRepository.findAccountByUserId(userId);
	  try {
		  List<Transaction> transactions= accountStatement.getAllRecords(acc.getAccountNumber());
		  List<StatementTransactionDto> statementTransactionDto = new ArrayList<>();
		  for(Transaction t: transactions) {
			  StatementTransactionDto stateTransaction = new StatementTransactionDto();
			  stateTransaction.setFromAccountNumber(t.getDebitAccount().getAccountNumber());
			  stateTransaction.setToAccountNumber(t.getCreditAccount().getAccountNumber());
			  stateTransaction.setDateTime(t.getTransactionDateTime());
			  stateTransaction.setTransactionId(t.getTransactionId());
			  stateTransaction.setRemark(t.getRemarks());
			  stateTransaction.setTransactionType(t.getTransactionType());
			  
			  statementTransactionDto.add(stateTransaction);
		  }
		  return statementTransactionDto;
		  
		  } catch (Exception e) {
		// TODO Auto-generated catch block
		throw new ServiceException("Error occured while fetching transactions");
	}
	  
  }




@Override
public List<StatementTransactionDto> accountHistory(int userId) {
	 Account acc = (Account) accountRepository.findAccountByUserId(userId);
	  try {
		  List<Transaction> transactions= accountStatement.getAccountHistory(acc.getAccountNumber());
		  List<StatementTransactionDto> statementTransactionDto = new ArrayList<>();
		  for(Transaction t: transactions) {
			  StatementTransactionDto stateTransaction = new StatementTransactionDto();
			  stateTransaction.setFromAccountNumber(t.getDebitAccount().getAccountNumber());
			  stateTransaction.setToAccountNumber(t.getCreditAccount().getAccountNumber());
			  stateTransaction.setDateTime(t.getTransactionDateTime());
			  stateTransaction.setTransactionId(t.getTransactionId());
			  stateTransaction.setRemark(t.getRemarks());
			  stateTransaction.setTransactionType(t.getTransactionType());
			  
			  statementTransactionDto.add(stateTransaction);
		  }
		  return statementTransactionDto;
		  

	  } catch (Exception e) {
	// TODO Auto-generated catch block
	throw new ServiceException("Error occured while fetching transactions");
	
}
}
}
	  
	  


  
  

	  
  




