package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.repository.UserRepository;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void sendEmailForUserId(int userId) {
		User user = userRepository.fetchById(User.class, userId);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@hfdc.com");
		message.setTo(user.getCustomer().getEmailId());
		message.setSubject("Your User ID");
		message.setText("Greetings " + user.getCustomer().getFirstName() + " " + user.getCustomer().getLastName()
				+ ". Your User ID is " + userId);
		mailSender.send(message);
	}

	@Override
	public void sendEmailOnAcceptance(Customer customer, int userId, int accountNumber) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@hfdc.com");
		message.setTo(customer.getEmailId());
		message.setSubject("Your request to open an account was approved");
		message.setText("Greetings " + customer.getFirstName() + " " + customer.getLastName()
				+ ". Your request for opening an account was accepted. User ID: " + userId + ". Account Number: "
				+ accountNumber);
		mailSender.send(message);
	}

	@Override
	public void sendEmailOnRejection(Customer customer) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@hfdc.com");
		message.setTo(customer.getEmailId());
		message.setSubject("Your request to open an account was rejected");
		message.setText("Greetings " + customer.getFirstName() + " " + customer.getMiddleName() + " "
				+ customer.getLastName()
				+ ". Your request for opening an account was rejected due to invalidity of submitted documents.");
		mailSender.send(message);
	}

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
	public void sendMailForOtp(String otp, User user) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@hfdc.com");
		message.setTo("dummyAdyasha@outlook.com");
		message.setSubject("Otp for the transaction");
		message.setText("Greetings "+ user.getCustomer().getFirstName()+" "+user.getCustomer().getLastName()+" ,  Your Otp for the transaction is "+otp);
		mailSender.send(message);
	}

}
