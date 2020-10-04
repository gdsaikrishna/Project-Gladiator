package com.lti.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.TransactionDto;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.exception.ServiceException;
import com.lti.repository.AccountRepository;
import com.lti.repository.TransactionRepository;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	public void fundTransfer(TransactionDto transactionDto) {
		try {
			if(!(transactionDto.getTransactionPassword()).equals(userRepository.fetchUserTransactionPassword(transactionDto.getUserId())))
					throw new ServiceException("Invalid Transaction Password");
			if(transactionDto.getAmount()<=0)
				throw new ServiceException("Enter a valid Transaction ammount");
			Transaction transaction=new Transaction();
			Account creditAccount=accountRepository.findAccountByAccountNumber(transactionDto.getToAccountNumber());
			Account debitAccount=accountRepository.findAccountByUserId(transactionDto.getUserId());
			transaction.setAmount(transactionDto.getAmount());			debit(debitAccount,transactionDto.getAmount());
			credit(creditAccount,transactionDto.getAmount());
			transaction.setDebitAccount(debitAccount);
			transaction.setCreditAccount(creditAccount);
			transaction.setRemarks(transactionDto.getRemarks());
			transaction.setTransactionDateTime(LocalDateTime.now());
			transaction.setTransactionType(transactionDto.getTransactionType());
			transactionRepository.save(transaction);
			
		}catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public void debit(Account account,double amount) {
		account.setBalance(account.getBalance()-amount);
		accountRepository.save(account);
	}
	
	public void credit(Account account,double amount) {
		account.setBalance(account.getBalance()+amount);
		accountRepository.save(account);
	}

}
