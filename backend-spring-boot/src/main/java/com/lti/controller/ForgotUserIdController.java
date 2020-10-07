package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CheckOtpStatus;
import com.lti.dto.ForgotUserId;
import com.lti.dto.ForgotUserIdStatus;
import com.lti.dto.Status.StatusCode;
import com.lti.exception.ServiceException;
import com.lti.service.ForgotUserIdService;
import com.lti.service.OtpService;

@RestController
@CrossOrigin
public class ForgotUserIdController {

	@Autowired
	private ForgotUserIdService service;

	@Autowired
	private OtpService otpService;

	@GetMapping(path = "/account-verification")
	public ForgotUserIdStatus verifyAccountNumberAndFetchUserId(@RequestParam("accountNumber") int acno) {
		try {
			ForgotUserIdStatus status = new ForgotUserIdStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Checking if account exists...");
			if (service.verifyAccountNumber(acno)) {
				status.setAccountExists(true);
				otpService.generateOtp(service.findUserId(acno));
			}
			else
				status.setAccountExists(false);
			status.setUserId(service.findUserId(acno));
			return status;
		} catch (Exception e) {
			ForgotUserIdStatus status = new ForgotUserIdStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Could not check if account exists");
			return status;
		}
	}

	@PostMapping(path = "/check-otp")
	public CheckOtpStatus verifyOtp(@RequestBody ForgotUserId forgotUserId) {
		try {
			CheckOtpStatus status = new CheckOtpStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Verifying OTP...");
			if (otpService.checkOtp(forgotUserId.getUserId(), forgotUserId.getOtp())) {
				status.setOtp(true);
				try {
					service.sendUserIdViaEmail(forgotUserId.getUserId());
				}
				catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
			}
			else
				status.setOtp(false);
			return status;
		} catch (Exception e) {
			CheckOtpStatus status = new CheckOtpStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Could not verify OTP");
			return status;
		}
	}
}
