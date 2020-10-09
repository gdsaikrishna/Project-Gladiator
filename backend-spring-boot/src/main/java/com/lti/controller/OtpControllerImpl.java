package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.dto.Status;
import com.lti.dto.Status.StatusCode;
import com.lti.exception.ServiceException;
import com.lti.service.OtpService;

@RestController
@CrossOrigin
public class OtpControllerImpl {
	
	@Autowired
	private OtpService otpService;

	@GetMapping(path = "/generate-otp")
	public Status getOtp(@RequestParam(name="userId") int userId) {

		try {
			boolean check = otpService.generateOtp(userId);
			Status status = new Status();
			if (check) {
				status.setStatusCode(StatusCode.SUCCESS);
				status.setStatusMessage("Otp Generated Successfully");
			} else {
				status.setStatusCode(StatusCode.FAILURE);
				status.setStatusMessage("Otp Generation Failed");
			}
			return status;
		} catch (ServiceException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage(e.getMessage());
			return status;
		}
	}
	

}
