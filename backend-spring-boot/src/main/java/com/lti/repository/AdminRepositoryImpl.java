package com.lti.repository;

import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;

@Repository
public class AdminRepositoryImpl extends GenericRepositoryImpl implements AdminRepository {

	@Override
	public boolean exists(int adminId) {
		Long count = (Long) entityManager.createQuery("select count(a.id) from Admin a where a.id = :adminId").setParameter("adminId", adminId).getSingleResult();
		if (count == 1)
			return true;
		else
			return false;
	}
	
	@Override
	public Admin fetchByIdAndPassword(int adminId, String pwd) {
		return (Admin) entityManager.createQuery("select a from Admin a where a.id=:adminId and a.password=:pwd").setParameter("adminId", adminId).setParameter("pwd", pwd).getSingleResult();
	}
	
}
