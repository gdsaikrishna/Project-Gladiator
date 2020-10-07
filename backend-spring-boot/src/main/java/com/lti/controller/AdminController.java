package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.AdminApproval;
import com.lti.dto.AdminLogin;
import com.lti.dto.AdminLoginStatus;
import com.lti.dto.CustomerRequestStatus;
import com.lti.dto.Status;
import com.lti.dto.Status.StatusCode;
import com.lti.entity.Admin;
import com.lti.exception.ServiceException;
import com.lti.service.AdminService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(path = "/admin-login")
	public AdminLoginStatus login(@RequestBody AdminLogin login) {
		try {
			Admin admin = adminService.login(login.getAdminId(), login.getPassword());

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

	@GetMapping(path = "/pending-requests")
	public CustomerRequestStatus showPendingRequests() {
		try {
			CustomerRequestStatus status = new CustomerRequestStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Searching for pending requests...");
			status.setCustomers(adminService.getPendingRequests());
			return status;
		} catch (ServiceException e) {
			CustomerRequestStatus status = new CustomerRequestStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Could not fetch requests");
			return status;
		}
	}

	@PutMapping(path = "/approve")
	public Status acceptanceOrRejection(@RequestBody AdminApproval apprvReject) {
		try {
			adminService.updatePendingRequests(apprvReject.getServiceRefNo(), apprvReject.getResponse());
			Status status = new Status();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Approval Successful");
			return status;
		} catch (ServiceException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			e.printStackTrace();
			return status;
		}
	}
}
