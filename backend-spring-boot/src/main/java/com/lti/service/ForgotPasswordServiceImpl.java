package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repository.UserRepository;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean verifyUser(int id) {
		if(userRepository.isUserExists(id))
			return true;
		return false;
	}
}
