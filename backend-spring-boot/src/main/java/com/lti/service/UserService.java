package com.lti.service;

import com.lti.entity.User;

public interface UserService {

	User login(int id, String password);
	boolean register(int userId , String userPassword , String transactionPassword ,String otp);
	boolean changePassword(int userId, String userPassword , String transactionPassword);

}