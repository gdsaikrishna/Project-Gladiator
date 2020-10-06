package com.lti.service;

import com.lti.entity.Customer;
import com.lti.entity.User;

public interface EmailService {

	void sendMailForNewRegistration(Customer customer);
	void sendMailForOtp(String otp ,User user);
}