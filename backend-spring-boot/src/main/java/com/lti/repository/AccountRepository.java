package com.lti.repository;

import java.util.List;

import com.lti.entity.Account;

public interface AccountRepository extends GenericRepository{

	boolean exists(int acno);
	<T> T findUserByAccountNoAndOtp(int accountNumber, int otp);
	Account findAccountByUserId(int userId);
	String checkUserHasInternetBankingWithGivenAcno(int accountNumber);
	boolean checkUserAlreadyRegistered(int accountNumber);
	int returnUserIdWithAccountNumber(int accountNumber);
	List<Account> fetchAccountsByUserId(int accountNumber);
	Account findAccountByAccountNumber(int accountNumber);
}