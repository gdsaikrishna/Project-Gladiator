package com.lti.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Account;
import com.lti.entity.Customer;
import com.lti.entity.ErrorLogin;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.AccountRepository;
import com.lti.repository.ErrorLoginRepository;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ErrorLoginRepository errorLoginRepository;
	
	@Autowired OtpService otpSerivce;
	
	@Override
	public User login(int id, String password) {
		try {
			if(userRepository.isUserExists(id)) {
				if(errorLoginRepository.checkErrorLoginCount(id))
					return userRepository.fetchUserWithUserIdAndPassword(id, password);
				else
					throw new ServiceException("User login attempts limit exceeded, Retry login after 24 hours ");
			}
			else
				throw new ServiceException("User not registered");
				
		}
		catch(EmptyResultDataAccessException e) {
			ErrorLogin errorLogin=new ErrorLogin();
			errorLogin.setDateAndTime(LocalDateTime.now());
			errorLogin.setUser(userRepository.fetchUserWithUserId(id));
			errorLoginRepository.save(errorLogin);
			throw new ServiceException("Invalid email/password");
		}
	}
	
	public boolean register(int userId , String userPassword , String transactionPassword, String otp) {
			if(userRepository.isUserExists(userId) && otpSerivce.checkOtp(userId, otp)) {
				if(userRepository.checkUserHasInternetBanking(userId).equals("Y")) {
					if(userRepository.checkUserAlreadyRegistered(userId)) 
						throw new ServiceException("User already Registered");
					else {
						User user= userRepository.fetchById(User.class, userId);
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
				throw new ServiceException("Invalid UserId/OTP");
	}
	
	public boolean changePassword(int userId, String userPassword , String transactionPassword) {
		if(userRepository.isUserExists(userId)) {
			User user = userRepository.fetchById(User.class, userId);
			user.setUserPassword(userPassword);
			user.setTransactionPassword(transactionPassword);
			userRepository.save(user);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean setNewPassword(int userId, String newPassword) {
		if(userRepository.isUserExists(userId)) {
			User user = userRepository.fetchById(User.class, userId);
			user.setUserPassword(newPassword);
			userRepository.save(user);
			return true;
		}
		else {
			return false;
		}
	}

}
