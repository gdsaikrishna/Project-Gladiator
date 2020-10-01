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
	
<<<<<<< HEAD
	@Override
	public List<Account> findAccountByUserId(int userId) {
		return entityManager
=======
	public Account findAccountByUserId(int userId) {
		return (Account) entityManager
>>>>>>> 10faa4ba45780c3f63b39c2a436ad16a1f432fef
				.createQuery("select a from Account a where a.user.id= :userId")
				.setParameter("userId", userId)
				.getSingleResult();
				
	}
	
}
