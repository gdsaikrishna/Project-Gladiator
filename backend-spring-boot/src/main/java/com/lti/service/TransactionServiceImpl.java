package com.lti.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.TransactionDto;
import com.lti.dto.TransactionSuccessDto;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.entity.User;
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
	
	@Autowired
	private OtpService otpService;
	
	public TransactionSuccessDto fundTransfer(TransactionDto transactionDto) {
		try {
			Account tranaccount=accountRepository.fetchById(Account.class, transactionDto.getFromAccountNumber());
			int userId=tranaccount.getUser().getId();
			User user=userRepository.fetchById(User.class, userId);
			if(!otpService.checkOtp(userId, transactionDto.getOtp()))
				throw new ServiceException("Incorrect Otp entered");
			if(!(transactionDto.getTransactionPassword()).equals(user.getTransactionPassword()))
					throw new ServiceException("Invalid Transaction Password");
			if(transactionDto.getAmount()<=0)
				throw new ServiceException("Enter a valid Transaction ammount");
			Transaction transaction=new Transaction();
			Account creditAccount=accountRepository.fetchById(Account.class, transactionDto.getToAccountNumber());
			Account debitAccount=accountRepository.fetchById(Account.class, transactionDto.getFromAccountNumber());
			
			if(debitAccount.getBalance()<transactionDto.getAmount())
				throw new ServiceException("Insufficient Balance in your acount");
			if(transactionDto.getAmount()>=20000)
				throw new ServiceException("Transaction greater than 20000 is not allowed");
			transaction.setAmount(transactionDto.getAmount());	
			debit(debitAccount,transactionDto.getAmount());
			credit(creditAccount,transactionDto.getAmount());
			transaction.setDebitAccount(debitAccount);
			transaction.setCreditAccount(creditAccount);
			transaction.setRemarks(transactionDto.getRemarks());
			transaction.setTransactionDateTime(LocalDateTime.now());
			transaction.setTransactionType(transactionDto.getTransactionType());
			TransactionSuccessDto transactionSuccessDto=new TransactionSuccessDto();
			Transaction updated =transactionRepository.fetchTransactionObjectAfterSaving(transaction);
			transactionSuccessDto.setId(updated.getTransactionId());
			transactionSuccessDto.setFromAccountNumber(updated.getDebitAccount().getAccountNumber());
			transactionSuccessDto.setToAccountNumber(updated.getCreditAccount().getAccountNumber());
			transactionSuccessDto.setTransactionType(updated.getTransactionType());
			transactionSuccessDto.setAmount(updated.getAmount());
			transactionSuccessDto.setRemarks(updated.getRemarks());
			return transactionSuccessDto;
			
			
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
