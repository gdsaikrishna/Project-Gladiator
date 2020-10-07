package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AccountSummaryStatus;
import com.lti.dto.Status.StatusCode;
import com.lti.entity.Account;
import com.lti.exception.ServiceException;
import com.lti.service.AccountSummaryService;

@RestController
@CrossOrigin
public class AccountSummaryController {
	
	@Autowired
	private AccountSummaryService service;
	
	@GetMapping(path = "/account-summary")
	public AccountSummaryStatus showUserProfile(@RequestParam("userId") int id) {
		try {
			List<Account> accounts=service.fetchAccountSummary(id);
			AccountSummaryStatus status=new AccountSummaryStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Fetched account summary successfully");
			status.setAcccountNumber(accounts.get(0).getAccountNumber());
			status.setBalance(accounts.get(0).getBalance());
			return status;
		} catch (Exception e) {
			AccountSummaryStatus status=new AccountSummaryStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Could no fetch account summary");
			return status;
		}
	}
}
