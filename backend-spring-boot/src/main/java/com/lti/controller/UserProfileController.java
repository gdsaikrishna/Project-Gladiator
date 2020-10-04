package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status.StatusCode;
import com.lti.dto.UserProfileStatus;
import com.lti.entity.Customer;
import com.lti.exception.ServiceException;
import com.lti.service.UserProfileService;

@RestController
@CrossOrigin
public class UserProfileController {

	@Autowired
	private UserProfileService service;
	
	@GetMapping(path = "/user-profile")
	@CrossOrigin
	public UserProfileStatus showUserProfile(@RequestParam("userId") int id) {
		try {
			Customer customer=service.fetchProfile(id);
			UserProfileStatus status=new UserProfileStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Fetched customer details successfully");
			status.setCustomer(customer);
			return status;
		} catch (Exception e) {
			UserProfileStatus status=new UserProfileStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Could not fetch user details");
			return status;
		}
	}
}
