package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Otp;
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
	
	@Override
	public boolean generateOtp(int userId) {
		if(userRepository.isUserExists(userId)) {
			Otp otp =new Otp();
			otp.setOtp(otpGenerator.generateOtp());
			otp.setUserId(userId);
			otpRepository.save(otp);
			//emailService
			return true;
		}
		else {
			throw new ServiceException("User does not exists");
		}
	}
	
	

}
