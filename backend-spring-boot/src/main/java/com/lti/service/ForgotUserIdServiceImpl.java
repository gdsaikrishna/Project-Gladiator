package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Account;
import com.lti.exception.ServiceException;
import com.lti.repository.AccountRepository;

@Service
public class ForgotUserIdServiceImpl implements ForgotUserIdService {

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private OtpService otpService;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public boolean verifyAccountNumber(int accountNumber) {
		if(repository.exists(accountNumber))
			return true;
		return false;
	}
	
	@Override
	public int findUserId(int accountNumber) {
		Account account = repository.fetchById(Account.class, accountNumber);
		return account.getUser().getId();
	}

	@Override
	public void sendUserIdViaEmail(int userId) {
		try {
			emailService.sendEmailForUserId(userId);
		} catch (Exception e) {
			throw new ServiceException("Could not send email");
		}
	}
}
