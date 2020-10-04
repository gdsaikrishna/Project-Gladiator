package com.lti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.dto.AdminApproval;
import com.lti.dto.AdminLogin;
import com.lti.dto.AdminLoginStatus;
import com.lti.dto.CustomerRequestStatus;
import com.lti.dto.Status;

public interface AdminController {

	AdminLoginStatus login(AdminLogin login);

	CustomerRequestStatus showPendingRequests();

	Status acceptanceOrRejection(AdminApproval apprvReject);

}