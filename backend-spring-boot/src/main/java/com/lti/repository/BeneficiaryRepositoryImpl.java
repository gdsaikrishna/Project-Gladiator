package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.dto.BeneficiaryDto;
import com.lti.entity.Beneficiary;
import com.lti.entity.User;

@Repository
public class BeneficiaryRepositoryImpl extends GenericRepositoryImpl implements BeneficiaryRepository  {
	
	public boolean checkIfAlreadyPresent(int userId,int beneficiaryAccountNumber) {
		return (Long)
				entityManager
				.createQuery("select count(b.id) from Beneficiary b where b.userId = :userId and b.account.accountNumber =:beneficiaryAccountNumber")
				.setParameter("userId", userId)
				.setParameter("beneficiaryAccountNumber", beneficiaryAccountNumber)
				.getSingleResult() == 0 ? false : true;
	}
	



	
	
}
