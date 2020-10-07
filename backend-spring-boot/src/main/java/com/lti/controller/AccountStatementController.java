package com.lti.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.entity.Transaction;
import com.lti.exception.ServiceException;
import com.lti.service.AccountStatementService;

@RestController
@CrossOrigin
public class  AccountStatementController {
	@Autowired
	private AccountStatementService accountStatementService;

	@GetMapping(path = "/AccountStatement/{userId}")
	public  List<Transaction>  getStatement(@PathVariable(value = "userId") int userId) {
		try {
			List<Transaction> list = accountStatementService.accountStatment(userId);
			return list;

		} catch (ServiceException e) {
          return null;
		}
       
	}
	public List<Transaction> getStatementHistory(@PathVariable(value = "accountNumber") int userId){
		try {
			List<Transaction> list = accountStatementService.accountHistory(userId);
			return list;
			
		}catch (ServiceException e) {
			return null;
		}
	}
}