package com.lti.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Otp;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.OtpRepository;
import com.lti.repository.UserRepository;

@Service
@Transactional
public class OtpServiceImpl implements OtpService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OtpGenerator otpGenerator;
	
	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	public boolean generateOtp(int userId) {
		if(userRepository.isUserExists(userId)) {
			User user= userRepository.fetchById(User.class, userId);
			Otp otp =new Otp();
			otp.setOtp(otpGenerator.generateOtp());
			otp.setUserId(userId);
			otp.setDateTime(LocalDateTime.now());
			otpRepository.save(otp);
			emailService.sendMailForOtp(otp.getOtp(), user);
			return true;
		}
		else {
			throw new ServiceException("User does not exists");
		}
	}
	
	public boolean checkOtp(int userId , String otp) {
		try {
			if(userRepository.isUserExists(userId)) {
				return otp.equals(otpRepository.getOtp(userId));
			}
			else {
				throw new ServiceException("User does not exists");
			}
		}
		catch(EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid Otp");
		}
		
	}
	
	

}
