package com.lti.service;

import java.util.List;

import com.lti.dto.AddBeneficiaryDto;
import com.lti.dto.ShowBeneficiaryDto;

public interface BeneficaryService {
	
	public void addNewBeneficiary(AddBeneficiaryDto beneficiaryDto);
	
	public List<ShowBeneficiaryDto> fetchBeneficiary(int userId);
	
	

}