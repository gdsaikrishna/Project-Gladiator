package com.lti.service;

import com.lti.entity.User;

public interface UserService {

	User login(int id, String password);
	boolean register(int accountNumber , String userPassword , String transactionPassword);

}