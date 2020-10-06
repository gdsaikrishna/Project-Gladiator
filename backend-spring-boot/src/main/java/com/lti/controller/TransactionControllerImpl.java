package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.dto.TransactionDto;
import com.lti.dto.TransactionSuccessDto;
import com.lti.dto.TransactionSuccessfulDto;
import com.lti.entity.Transaction;
import com.lti.dto.Status.StatusCode;
import com.lti.exception.ServiceException;
import com.lti.service.TransactionService;

@RestController
@CrossOrigin
public class TransactionControllerImpl {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping(path = "/fund-transfer")
	public Status fundTransfer(@RequestBody TransactionDto transactionDto) {
		try {
			TransactionSuccessDto transaction=transactionService.fundTransfer(transactionDto);
		    
			TransactionSuccessfulDto status=new TransactionSuccessfulDto();
			status.setTransactionSuccessDto(transaction);
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Transaction Successful");
			return status;
			
		}catch (ServiceException e) {
			TransactionSuccessfulDto status=new TransactionSuccessfulDto();
			status.setTransactionSuccessDto(null);
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
}
