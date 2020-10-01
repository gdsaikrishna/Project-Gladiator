package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
			User user =userService.login(login.getUserId(), login.getPassword());
			UserLoginStatus userLoginStatus = new UserLoginStatus();
			userLoginStatus.setStatusCode(StatusCode.SUCCESS);
			userLoginStatus.setStatusMessage("Login Successful");
			userLoginStatus.setUserId(user.getId());
			userLoginStatus.setUserName(user.getCustomer().getFirstName());
			return userLoginStatus;
		}
		catch (ServiceException e) {
			UserLoginStatus userLoginStatus = new UserLoginStatus();
			userLoginStatus.setStatusCode(StatusCode.FAILURE);;
			userLoginStatus.setStatusMessage("Some Error occured while logging in, Retry Login");
			return userLoginStatus;
		}
	}

}
