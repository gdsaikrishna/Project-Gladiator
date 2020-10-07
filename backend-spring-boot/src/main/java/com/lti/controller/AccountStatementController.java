package com.lti.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AccountStatementDto;
import com.lti.dto.Status.StatusCode;
import com.lti.entity.Transaction;
import com.lti.exception.ServiceException;
import com.lti.service.AccountStatementService;

@RestController
@CrossOrigin
public class  AccountStatementController {
	@Autowired
	private AccountStatementService accountStatementService;

	@GetMapping(path = "/AccountStatement/{userId}")
	public AccountStatementDto  getStatement(@PathVariable(value = "accountNumber") int userId) {
		try {
			AccountStatementDto accountstate = new AccountStatementDto();
			accountstate.setStatusCode(StatusCode.SUCCESS);
			accountstate.setStatusMessage("Success");
			accountstate.setStatementTransactionDto(accountStatementService.accountStatment(userId));
			return accountstate;

		} catch (ServiceException e) {
			AccountStatementDto accountstate = new AccountStatementDto();
			accountstate.setStatusCode(StatusCode.FAILURE);
			accountstate.setStatusMessage("SuccessFail");
			accountstate.setStatementTransactionDto(null);
			return accountstate;
          
		}
       
	}
	
	
}