package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl implements AccountRepository {

	public <T> T findUserByAccountNoAndOtp(int accountNumber, int otp) {
		return (T) entityManager.createQuery("select distinct u from User u join u.accounts.accountNumber a where a.accountNumber = :acno").setParameter("acno", accountNumber).getSingleResult();
	}
}
