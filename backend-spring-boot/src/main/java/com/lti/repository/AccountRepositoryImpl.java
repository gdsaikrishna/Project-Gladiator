package com.lti.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.lti.entity.Account;

@Repository
public class AccountRepositoryImpl extends GenericRepositoryImpl implements AccountRepository {

	@Override
	public boolean exists(int acno) {
		long count = ((Long) entityManager
				.createQuery("select count(a.accountNumber) from Account a where a.accountNumber = :acno")
				.setParameter("acno", acno).getSingleResult());
		if (count == 0)
			return false;
		else
			return true;
	}

	@Override
	public <T> T findUserByAccountNoAndOtp(int accountNumber, int otp) {
		return (T) entityManager
				.createQuery(
						"select distinct u from User u join u.accounts.accountNumber a where a.accountNumber = :acno")
				.setParameter("acno", accountNumber).getSingleResult();
	}

	@Override
	public Account findAccountByUserId(int userId) {
		return (Account) entityManager.createQuery("select a from Account a where a.user.id= :userId")
				.setParameter("userId", userId).getSingleResult();

	}

	@Override
	public String checkUserHasInternetBankingWithGivenAcno(int accountNumber) {
		return (String) entityManager.createQuery(
				" select c.netBankingRequirement from Account a join a.user u join u.customer c where a.accountNumber = :accountNumber")
				.setParameter("accountNumber", accountNumber).getSingleResult();
	}

	@Override
	public boolean checkUserAlreadyRegistered(int accountNumber) {
		return (boolean) entityManager.createQuery(
				" select case when u.userPassword is not null then true else false end from Account a join a.user u where a.accountNumber = :accountNumber")
				.setParameter("accountNumber", accountNumber).getSingleResult();
	}

	/*
	 * @Override public int returnUserIdWithAccountNumber(int accountNumber) {
	 * return (int) entityManager
	 * .createQuery(" select u.id from Account a join a.user u where a.accountNumber = :accountNumber"
	 * ) .setParameter("accountNumber", accountNumber) .getSingleResult();
	 * 
	 * }
	 */

	@Override
	public List<Account> fetchAccountsByUserId(int accountNumber) {
		return entityManager.createQuery("select a from Account a where a.user = :id").setParameter("id", accountNumber)
				.getResultList();
	}

	@Override
	public Account findAccountByAccountNumber(int accountNumber) {
		return (Account) entityManager.createQuery("select a from Account a where a.accountNumber =:accountNumber")
				.setParameter("accountNumber", accountNumber).getSingleResult();

	}
}
