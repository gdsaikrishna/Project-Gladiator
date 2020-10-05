package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lti.dto.ChangePassword;
import com.lti.dto.RegisterIb;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusCode;
import com.lti.dto.UserLogin;
import com.lti.dto.UserLoginStatus;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.service.UserService;

@Controller
public class UserControllerImpl {

	@Autowired
	private UserService userService;

	@PostMapping("/user-login")
	@CrossOrigin
	public @ResponseBody UserLoginStatus login(@RequestBody UserLogin login) {

		try {
			User user = userService.login(login.getUserId(), login.getPassword());
			UserLoginStatus userLoginStatus = new UserLoginStatus();
			userLoginStatus.setStatusCode(StatusCode.SUCCESS);
			userLoginStatus.setStatusMessage("Login Successful");
			userLoginStatus.setUserId(user.getId());
			userLoginStatus.setUserName(user.getCustomer().getFirstName());
			return userLoginStatus;
		} catch (ServiceException e) {
			UserLoginStatus userLoginStatus = new UserLoginStatus();
			userLoginStatus.setStatusCode(StatusCode.FAILURE);
			;
			userLoginStatus.setStatusMessage(e.getMessage());
			return userLoginStatus;
		}
	}

	@PostMapping("/register-ib")
	@CrossOrigin
	public @ResponseBody Status register(@RequestBody RegisterIb registerIb) {
		try {
			boolean check = userService.register(registerIb.getAccountNumber(), registerIb.getUserPassword(),
					registerIb.getTransactionPassword());
			Status status = new Status();
			if (check) {
				status.setStatusCode(StatusCode.SUCCESS);
				status.setStatusMessage("Registration Success");
			} else {
				status.setStatusCode(StatusCode.FAILURE);
				status.setStatusMessage("Registration Failed");
			}
			return status;
		} catch (ServiceException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}

	}

	@PostMapping("/change-password")
	@CrossOrigin
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

}
