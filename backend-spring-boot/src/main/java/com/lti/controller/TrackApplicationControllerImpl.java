package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status.StatusCode;
import com.lti.dto.TrackApplicationStatus;
import com.lti.exception.ServiceException;
import com.lti.service.TrackApplicationService;

@RestController
@CrossOrigin
public class TrackApplicationControllerImpl implements TrackApplicationController {

	@Autowired
	private TrackApplicationService trackApplicationService;

	@Override
	@GetMapping(path = "/track-application")
	public TrackApplicationStatus getApplicationStatus(@RequestParam("serviceRefNo") int serviceRefNo) {
		try {
			TrackApplicationStatus status = new TrackApplicationStatus();
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Tracking data fetched successfully");
			status.setCurrentStatus(trackApplicationService.fetchStatus(serviceRefNo));
			return status;
		} catch (ServiceException e) {
			TrackApplicationStatus status = new TrackApplicationStatus();
			status.setStatusCode(StatusCode.FAILURE);
			status.setCurrentStatus("Tracking data fetching failed");
			return status;
		}
	}
}
