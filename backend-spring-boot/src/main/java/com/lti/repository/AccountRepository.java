package com.lti.repository;

public interface AccountRepository {

	<T> T findUserByAccountNoAndOtp(int accountNumber, int otp);
}