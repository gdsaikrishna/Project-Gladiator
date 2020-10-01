package com.lti.repository;

import com.lti.entity.Beneficiary;

public interface BeneficiaryRepository {
	public boolean checkIfAlreadyPresent(int userId,int beneficiaryAccountNumber);


}