package com.lti.repository;

public interface AccountRepository {

//	boolean exists(int acno);
	<T> T findUserByAccountNoAndOtp(int accountNumber, int otp);

//	boolean exists(int acno);
}