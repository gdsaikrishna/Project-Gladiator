package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.dto.AddBeneficiaryDto;
import com.lti.entity.Beneficiary;
import com.lti.entity.User;

@Repository
public class BeneficiaryRepositoryImpl extends GenericRepositoryImpl implements BeneficiaryRepository  {
	
	public boolean checkIfAlreadyPresent(int userId,int beneficiaryAccountNumber) {
		long count= (Long)
				entityManager
				.createQuery("select count(b.id) from Beneficiary b where b.user.id = :userId and b.account.accountNumber =:beneficiaryAccountNumber")
				.setParameter("userId", userId)
				.setParameter("beneficiaryAccountNumber", beneficiaryAccountNumber)
				.getSingleResult();
		System.out.println(count);
		return count== 0 ? false : true;
	}
	
	public List<Beneficiary> fetchBeneficiaryList(int userId) {
		List<Beneficiary> list=entityManager
									.createQuery("select b from Beneficiary b where b.user.id = :userId")
									.setParameter("userId", userId)
									.getResultList();
		return list;
	}
	
	public boolean checkIfAnyBeneficiaryExist(int userId) {
		return (Long)
				entityManager
				.createQuery("select count(b.id) from Beneficiary b where b.user.id = :userId")
				.setParameter("userId", userId)
				.getSingleResult() == 0 ? false : true;
	}
	


	
	
}
