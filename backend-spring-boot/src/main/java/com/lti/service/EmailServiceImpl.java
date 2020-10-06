package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.lti.entity.Customer;

public class EmailServiceImpl {
	@Autowired
	private MailSender mailSender;
	
	public void sendMailForNewRegistration(Customer customer) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@hfdc.com");
		message.setTo(customer.getEmailId());
		message.setSubject("Thank you for Registering to open a Savings account");
		message.setText("Greetings "+ customer.getFirstName()+" "+customer.getMiddleName()+" "+customer.getLastName());
		mailSender.send(message);
	}
}
