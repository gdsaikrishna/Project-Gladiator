package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.CheckOtpStatus;
import com.lti.dto.ForgotPassword;
import com.lti.dto.ForgotPasswordStatus;
import com.lti.dto.Status.StatusCode;
import com.lti.service.ForgotPasswordService;
import com.lti.service.OtpService;

@RestController
@CrossOrigin
public class ForgotPasswordController {

	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	@Autowired
	private OtpService otpService;
	
	@GetMapping(path = "/forgot-password")
	public ForgotPasswordStatus verifyUserIdAndSendOtp(@RequestParam("userId") int id) {
		try {
			ForgotPasswordStatus status=new ForgotPasswordStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Trying to send OTP...");
			if(forgotPasswordService.verifyUser(id)) {
				status.setUserExists(true);
				otpService.generateOtp(id);
			}
			else
				status.setUserExists(false);
			return status;
		} catch (Exception e) {
			ForgotPasswordStatus status=new ForgotPasswordStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Could not send OTP");
			return status;
		}
	}
	
	@PostMapping(path = "/verify-otp")
	public CheckOtpStatus verifyOtp(@RequestBody ForgotPassword forgotPassword) {
		System.out.println(forgotPassword.getUserId()+forgotPassword.getOtp());
		try {
			CheckOtpStatus status=new CheckOtpStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Trying to verify OTP...");
			if(otpService.checkOtp(forgotPassword.getUserId(), forgotPassword.getOtp()))
				status.setOtp(true);
			else
				status.setOtp(false);
			return status;
		} catch (Exception e) {
			CheckOtpStatus status=new CheckOtpStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Could not verify OTP");
			return status;
		}
	}
}
