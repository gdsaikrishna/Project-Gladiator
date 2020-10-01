package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User login(int id, String password) {
		try {
			if(!userRepository.isUserExists(id))
				throw new ServiceException("User not registered");
			return userRepository.fetchUserWithUserIdAndPassword(id, password);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid email/password");
		}
	}

}
