package com.lti.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.lti.entity.Account;

@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl implements AccountRepository {
	
	public boolean exists(int acno) {
		long count=((Long) 
				entityManager.
				createQuery("select count(a) from Account a where a.accountNumber = :acno")
				.setParameter("acno", acno)
				.getSingleResult()) ;
		if(count==0)
			return false;
		else
			return true;
	}
	
	@Override
	public <T> T findUserByAccountNoAndOtp(int accountNumber, int otp) {
		return (T) entityManager.createQuery("select distinct u from User u join u.accounts.accountNumber a where a.accountNumber = :acno").setParameter("acno", accountNumber).getSingleResult();
	}
	

	public Account findAccountByUserId(int userId) {
		return (Account) entityManager
				.createQuery("select a from Account a where a.user.id= :userId")
				.setParameter("userId", userId)
				.getSingleResult();
				
	}
	
	public String checkUserHasInternetBankingWithGivenAcno(int accountNumber) {
		return (String)
				entityManager
				.createQuery(" select c.netBankingRequirement from Account a join a.user u join u.customer c where a.accountNumber = :accountNumber")
				.setParameter("accountNumber", accountNumber)
				.getSingleResult();
	}
	
	public boolean checkUserAlreadyRegistered(int accountNumber) {
		return (boolean)
				entityManager
				.createQuery(" select case when u.userPassword is not null then true else false end from Account a join a.user u where a.accountNumber = :accountNumber")
				.setParameter("accountNumber", accountNumber)
				.getSingleResult();
	}
	
	public int returnUserIdWithAccountNumber(int accountNumber) {
		return (int)
				entityManager
				.createQuery(" select a.user.id from Account a where a.accountNumber = :accountNumber")
				.setParameter("accountNumber", accountNumber)
				.getSingleResult();
				
	}
	
}
