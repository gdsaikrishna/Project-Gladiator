package com.lti.service;

public interface OtpService {
	
	boolean generateOtp(int userId);
	public boolean checkOtp(int userId , String otp);

}