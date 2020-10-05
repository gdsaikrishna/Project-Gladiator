package com.lti.repository;

import java.util.List;

import com.lti.entity.Beneficiary;

public interface BeneficiaryRepository extends GenericRepository {
	
	public boolean checkIfAlreadyPresent(int userId,int beneficiaryAccountNumber);
	
	public List<Beneficiary> fetchBeneficiaryList(int userId);
	
	public boolean checkIfAnyBeneficiaryExist(int userId);
	
	public String fetchCustomerNameFromAccountNumber(int accountNumber);


}