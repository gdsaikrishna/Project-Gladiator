package com.lti.repository;

import com.lti.entity.Beneficiary;

public interface BeneficiaryRepository extends GenericRepository {
	
	public boolean checkIfAlreadyPresent(int userId,int beneficiaryAccountNumber);


}