package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.BeneficiaryDto;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusCode;
import com.lti.exception.ServiceException;
import com.lti.service.BeneficaryService;

@RestController
@CrossOrigin
public class BeneficiaryControllerImpl {
	
	@Autowired
	BeneficaryService beneficiaryService;
	
	@PostMapping(path="/addBeneficiary")
	public Status addNewBeneficiary(@RequestBody BeneficiaryDto beneficiaryDto) {
		try {
			beneficiaryService.addNewBeneficiary(beneficiaryDto);
			Status status=new Status();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Beneficiary Added Successfully");
			return status;
			
		}catch (ServiceException e) {
			
			Status status = new Status();
			status.setStatusMessage(e.getMessage());
			status.setStatusCode(StatusCode.FAILURE);
			return status;
		}
	}
	
}
