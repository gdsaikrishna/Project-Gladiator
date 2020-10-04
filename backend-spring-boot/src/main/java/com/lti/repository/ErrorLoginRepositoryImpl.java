package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ErrorLoginRepositoryImpl extends GenericRepositoryImpl implements ErrorLoginRepository{
	
	@Override
	public boolean checkErrorLoginCount(int userId) {
		return (Long)
				entityManager
				.createQuery("select count(e.user.id) from ErrorLogin e where e.user.id = :id and e.dateAndTime>= SYSDATE - 1")
				.setParameter("id", userId)
				.getSingleResult() <= 5 ?true : false;
	}
	

}
