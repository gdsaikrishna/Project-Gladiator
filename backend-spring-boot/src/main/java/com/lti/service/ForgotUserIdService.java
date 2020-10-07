package com.lti.service;

public interface ForgotUserIdService {

	boolean verifyAccountNumber(int accountNumber);
	int findUserId(int accountNumber);
	void sendUserIdViaEmail(int userId);
}