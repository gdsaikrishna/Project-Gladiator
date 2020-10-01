package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User login(int id, String password) {
		try {
			System.out.println("Come");
			if(!userRepository.isUserExists(id))
				throw new ServiceException("User not registered");
			System.out.println("Become");
			return userRepository.fetchUserWithUserIdAndPassword(id, password);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid email/password");
		}
	}

}
