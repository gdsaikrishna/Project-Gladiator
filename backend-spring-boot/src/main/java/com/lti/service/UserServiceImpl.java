package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.AccountRepository;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public User login(int id, String password) {
		try {
			//System.out.println("Come");
			if(!userRepository.isUserExists(id))
				throw new ServiceException("User not registered");
			//System.out.println("Become");
			return userRepository.fetchUserWithUserIdAndPassword(id, password);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid email/password");
		}
	}
	
	public boolean register(int accountNumber , String userPassword , String transactionPassword) {
		try {
			if(accountRepository.exists(accountNumber)) {
				if(accountRepository.checkUserHasInternetBankingWithGivenAcno(accountNumber).equals("Y")) {
					if(accountRepository.checkUserAlreadyRegistered(accountNumber)) 
						throw new ServiceException("User already Registered");
					else {
						User user= new User();
						user.setId(accountRepository.returnUserIdWithAccountNumber(accountNumber));
						user.setUserPassword(userPassword);
						user.setTransactionPassword(transactionPassword);
						userRepository.save(user);
						return true;
						
					}
						
				}
				else
					throw new ServiceException("Customer didn't opt for Net-Banking when opening an account");
			}
			else 
				throw new ServiceException("Account Number Invalid");
		}
		catch(Exception e) {
			throw new ServiceException("Some Error occured while registering");
		}
	}

}
