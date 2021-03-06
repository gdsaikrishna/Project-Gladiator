package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ChangePassword;
import com.lti.dto.RegisterIb;
import com.lti.dto.SetNewPassword;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusCode;
import com.lti.dto.UserLogin;
import com.lti.dto.UserLoginStatus;
import com.lti.dto.UserProfileStatus;
import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.service.UserProfileService;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserControllerImpl {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserProfileService service;
	
	@PostMapping("/user-login")
	public @ResponseBody UserLoginStatus login(@RequestBody UserLogin login) {

		try {
			User user = userService.login(login.getUserId(), login.getPassword());
			UserLoginStatus userLoginStatus = new UserLoginStatus();
			userLoginStatus.setStatusCode(StatusCode.SUCCESS);
			userLoginStatus.setStatusMessage("Login Successful");
			userLoginStatus.setUserId(user.getId());
			userLoginStatus.setUserName(user.getCustomer().getFirstName());
			return userLoginStatus;
		}
		catch (ServiceException e) {
			UserLoginStatus userLoginStatus = new UserLoginStatus();
			userLoginStatus.setStatusCode(StatusCode.FAILURE);
			userLoginStatus.setStatusMessage(e.getMessage());
			return userLoginStatus;
		}
	}

	@PostMapping("/register-ib")
	public @ResponseBody Status register(@RequestBody RegisterIb registerIb) {
		try {
			boolean check = userService.register(registerIb.getUserId(), registerIb.getUserPassword(),
					registerIb.getTransactionPassword(), registerIb.getOtp());
			Status status = new Status();
			if (check) {
				status.setStatusCode(StatusCode.SUCCESS);
				status.setStatusMessage("Registration Successful");
			} else {
				status.setStatusCode(StatusCode.FAILURE);
				status.setStatusMessage("Registration Failed");
			}
			return status;
		} 
		catch (ServiceException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}

	}

	@PostMapping("/change-password")
	public @ResponseBody Status changePassword(@RequestBody ChangePassword changePassoword) {

		boolean check = userService.changePassword(changePassoword.getUserId(), changePassoword.getUserPassword(),
				changePassoword.getTransactionPassword());
		Status status = new Status();
		if (check) {
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Password change successful");
		} else {
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Password change failed");
		}
		return status;

	}
	
	
	@PostMapping("/set-new-password")
	public @ResponseBody Status setNewPassword(@RequestBody SetNewPassword setNewPassword) {
		boolean check = userService.setNewPassword(setNewPassword.getUserId(), setNewPassword.getNewPassword());
		Status status = new Status();
		if (check) {
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Password change successful");
		} else {
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Password change failed");
		}
		return status;

	}
	
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
