package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity.User;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl implements UserRepository {
	
	@Override
	public boolean isUserExists(int id) {
		return (Long)
				entityManager
				.createQuery("select count(u.id) from User u where c.id = :id")
				.setParameter("id", id)
				.getSingleResult() == 1 ?true : false;
	}
	
	@Override
	public User fetchUserWithUserIdAndPassword(int id, String password) {
		return (User)
				entityManager
				.createQuery("select u from User u where u.id= :id and u.password = :pw")
				.setParameter("id", id)
				.setParameter("pw", password)
				.getSingleResult();
		
		
	}
	

}
