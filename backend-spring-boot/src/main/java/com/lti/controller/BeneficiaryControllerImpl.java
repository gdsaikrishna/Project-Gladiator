package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AddBeneficiaryDto;
import com.lti.dto.ShowBeneficiaryDto;
import com.lti.dto.ShowBeneficiaryStatus;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusCode;
import com.lti.exception.ServiceException;
import com.lti.service.BeneficaryService;

@RestController
@CrossOrigin
public class BeneficiaryControllerImpl {
	
	@Autowired
	private BeneficaryService beneficiaryService;
	
	@PostMapping(path="/add-beneficiary")
	public Status addNewBeneficiary(@RequestBody AddBeneficiaryDto beneficiaryDto) {
	
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
	
	@GetMapping(path="/show-beneficiary")
	public ShowBeneficiaryStatus showBeneficiaries(@RequestParam("userId") int userId){
		 try{
			 
			 List<ShowBeneficiaryDto> list= beneficiaryService.fetchBeneficiary(userId);
			 ShowBeneficiaryStatus status=new ShowBeneficiaryStatus();
			 status.setBeneficiaryDto(list);
			 status.setStatusCode(StatusCode.SUCCESS);
			 status.setStatusMessage("Beneficiary Fetched Successfully");
			 return status;
		}catch (ServiceException e) {
			 ShowBeneficiaryStatus status=new ShowBeneficiaryStatus();
			 status.setBeneficiaryDto(null);
			 status.setStatusCode(StatusCode.FAILURE);
			 status.setStatusMessage(e.getMessage());
			 return status;
		}
	}
	
}
