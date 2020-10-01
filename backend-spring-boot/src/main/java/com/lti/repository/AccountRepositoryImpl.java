package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Account;

@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl implements AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;
	public boolean exists(int acno) {
		Long count = (Long) entityManager.createQuery("select count(a.accountNumber) from Account a where a.accountNumber = :acno").setParameter("acno", acno).getSingleResult();
		if (count == 1)
			return true;
			return false;
	}
	
	@Override
	public <T> T findUserByAccountNoAndOtp(int accountNumber, int otp) {
		return (T) entityManager.createQuery("select distinct u from User u join u.accounts.accountNumber a where a.accountNumber = :acno").setParameter("acno", accountNumber).getSingleResult();
	}
	
	public List<Account> findAccountByUserId(int userId) {
		return entityManager
				.createQuery("select a from Account a where a.user.id= :userId")
				.setParameter("userId", userId)
				.getResultList();
				
	}
	
}
