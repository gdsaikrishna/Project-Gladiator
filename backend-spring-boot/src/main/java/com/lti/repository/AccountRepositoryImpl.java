package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl implements AccountRepository {

	public boolean exists(int acno) {
		Long count = (Long) entityManager.createQuery("select count(a.accountNumber) from Account a where a.accountNumber = :acno").setParameter("acno", acno).getSingleResult();
		if (count == 1)
			return true;
		else
			return false;
	}
	
	@Override
	public <T> T findUserByAccountNoAndOtp(int accountNumber, int otp) {
		return (T) entityManager.createQuery("select distinct u from User u join u.accounts.accountNumber a where a.accountNumber = :acno").setParameter("acno", accountNumber).getSingleResult();
	}
	
}
