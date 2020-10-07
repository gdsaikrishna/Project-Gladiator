package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.entity.User;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private MailSender mailSender;
	
	@Override
	public void sendMailForNewRegistration(Customer customer) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@hfdc.com");
		message.setTo(customer.getEmailId());
		message.setSubject("Thank you for Registering to open a Savings account");
		message.setText("Greetings "+ customer.getFirstName()+" "+customer.getLastName());
		mailSender.send(message);
	}
	@Override
	public void sendMailForOtp(String otp ,User user) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@hfdc.com");
		message.setTo("dummyAdyasha@outlook.com");
		message.setSubject("Otp for the transaction");
		message.setText("Greetings "+ user.getCustomer().getFirstName()+" "+user.getCustomer().getLastName()+" ,  Your Otp for the transaction is "+otp);
		mailSender.send(message);
	}
	
	
}
