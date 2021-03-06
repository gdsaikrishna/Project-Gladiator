package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl implements UserRepository {
	
	@Override
	public boolean isUserExists(int id) {
		return (Long)
				entityManager
				.createQuery("select count(u.id) from User u where u.id = :id")
				.setParameter("id", id)
				.getSingleResult() == 1 ?true : false;
	}
	
	@Override
	public User fetchUserWithUserIdAndPassword(int id, String password) {
		return (User)
				entityManager
				.createQuery("select u from User u where u.id= :id and u.userPassword = :pw")
				.setParameter("id", id)
				.setParameter("pw", password)
				.getSingleResult();
		
		
	}
	public User fetchUserWithUserId(int id) {
		return (User)
				entityManager
				.createQuery("select u from User u where u.id = :id")
				.setParameter("id", id)
				.getSingleResult();
		
		
	}
	
	@Override
	public String fetchUserTransactionPassword(int id) {
		return (String)
				entityManager
				.createQuery("select u.transactionPassword from User u where u.id =:id")
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public boolean checkUserAlreadyRegistered(int userId) {
		return (boolean)
				entityManager
				.createQuery(" select case when u.userPassword is not null then true else false end from User u where u.id = :userId")
				.setParameter("userId", userId)
				.getSingleResult();
	}
	
	public String checkUserHasInternetBanking(int userId) {
		return (String)
				entityManager
				.createQuery(" select c.netBankingRequirement from User u join u.customer c where u.id = :userId")
				.setParameter("userId", userId)
				.getSingleResult();
	}
	
	

}
