package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lti.dto.OpenAccStatus;
import com.lti.dto.Status.StatusCode;
import com.lti.entity.Customer;
import com.lti.exception.ServiceException;
import com.lti.service.CustomerService;

@Controller
public class CustomerControllerImpl {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/openAccount")
	@CrossOrigin
	public @ResponseBody OpenAccStatus openAccount(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			OpenAccStatus status = new OpenAccStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Registration Successful");
			status.setServiceRefNo(id);
			return status;

		} catch (ServiceException e) {
			OpenAccStatus status = new OpenAccStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Registration Failed");
			return status;

		}
	}
	
	

}
