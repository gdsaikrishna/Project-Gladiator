package com.lti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.dto.TrackApplicationStatus;

public interface TrackApplicationController {

	TrackApplicationStatus getApplicationStatus(int serviceRefNo);

}