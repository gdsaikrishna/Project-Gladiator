package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.UserRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public Customer fetchProfile(int id) {
		try {
			User user = repository.fetchById(User.class, id);
			Customer customer = user.getCustomer();
			return customer;
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("User not found");
		}
	}
}
