package com.lti.repository;

import java.util.List;

import com.lti.entity.Account;

public interface AccountRepository extends GenericRepository{

	boolean exists(int acno);
	<T> T findUserByAccountNoAndOtp(int accountNumber, int otp);

//	boolean exists(int acno);
	
	public Account findAccountByUserId(int userId);
	boolean checkUserAlreadyRegistered(int accountNumber);
	String checkUserHasInternetBankingWithGivenAcno(int accountNumber);
	int returnUserIdWithAccountNumber(int accountNumber);
	public Account findAccountByAccountNumber(int accountNumber);
}