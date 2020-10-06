package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class OtpRepositoryImpl extends GenericRepositoryImpl implements OtpRepository {

	public String getOtp(int userId) {
		return (String)
				entityManager
				.createQuery("select o.otp from Otp o where o.dateTime >SYSDATE - 5/1440 and o.userId= :userId and rownum = 1 order by o.dateTime desc")
				.setParameter("userId", userId)
				.getSingleResult();
	}
}
