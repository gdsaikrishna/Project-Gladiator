package com.lti.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AccountStatementDto;
import com.lti.dto.StatementDuration;
import com.lti.dto.Status.StatusCode;
import com.lti.entity.Transaction;
import com.lti.exception.ServiceException;
import com.lti.service.AccountStatementService;

@RestController
@CrossOrigin
public class  AccountStatementController {
	@Autowired
	private AccountStatementService accountStatementService;

	@PostMapping(path = "/account-statement")
	public AccountStatementDto  getStatement(@RequestBody StatementDuration statementDuration) {
		try {
			AccountStatementDto accountstate = new AccountStatementDto();
			accountstate.setStatusCode(StatusCode.SUCCESS);
			accountstate.setStatusMessage("Success");
			accountstate.setStatementTransactionDto(accountStatementService.accountStatment(statementDuration));
			return accountstate;

		} catch (ServiceException e) {
			AccountStatementDto accountstate = new AccountStatementDto();
			accountstate.setStatusCode(StatusCode.FAILURE);
			accountstate.setStatusMessage(e.getMessage());
			accountstate.setStatementTransactionDto(null);
			return accountstate;
          
		}
       
	}
	
	
}