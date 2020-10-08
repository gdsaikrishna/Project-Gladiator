package com.lti.service;

import com.lti.entity.Customer;
import com.lti.entity.User;

public interface EmailService {
	
	void sendEmailForUserId(int userId);

	void sendEmailOnAcceptance(Customer customer, int userId, int accountNumber);

	void sendEmailOnRejection(Customer customer);

	void sendMailForNewRegistration(Customer customer);

	void sendMailForOtp(String otp, User user);

}