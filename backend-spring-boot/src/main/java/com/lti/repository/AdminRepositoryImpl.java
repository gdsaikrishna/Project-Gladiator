package com.lti.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.lti.entity.Admin;
import com.lti.entity.Customer;

@Repository
public class AdminRepositoryImpl extends GenericRepositoryImpl implements AdminRepository {
	@Override
	public boolean exists(int adminId) {
		return (Long) entityManager.createQuery("select count(a.id) from Admin a where a.id = :adminId")
				.setParameter("adminId", adminId).getSingleResult() == 1 ? true : false;
	}

	@Override
	public Admin fetchByIdAndPassword(int adminId, String pwd) {
		return (Admin) entityManager.createQuery("select a from Admin a where a.id = :adminId and a.password = :pwd")
				.setParameter("adminId", adminId).setParameter("pwd", pwd).getSingleResult();
	}

	@Override
	public List<Customer> fetchPendingRequests() {
		return entityManager.createQuery("select c from Customer c where c.isApproved = :apvd").setParameter("apvd", "W").getResultList();
	}
}
