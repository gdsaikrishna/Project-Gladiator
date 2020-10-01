package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminLogin;
import com.lti.dto.AdminLoginStatus;
import com.lti.dto.Status.StatusCode;
import com.lti.entity.Admin;
import com.lti.exception.ServiceException;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminControllerImpl {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/admin-login")
	public AdminLoginStatus login(@RequestBody AdminLogin login) {
		try {
			Admin admin=adminService.login(login.getAdminId(), login.getPassword());

			AdminLoginStatus loginStatus = new AdminLoginStatus();
			loginStatus.setStatusCode(StatusCode.SUCCESS);
			loginStatus.setStatusMessage("Login Successful");
			loginStatus.setAdminId(admin.getId());
			loginStatus.setName(admin.getName());
			return loginStatus;
		} catch (ServiceException e) {
			AdminLoginStatus loginStatus = new AdminLoginStatus();
			loginStatus.setStatusCode(StatusCode.FAILURE);
			loginStatus.setStatusMessage("Login Failed");
			return loginStatus;
		}
	}
}
