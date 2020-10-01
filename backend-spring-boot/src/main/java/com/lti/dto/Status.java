package com.lti.dto;

public class Status {

	private StatusCode statusCode;
	private String statusMessage;
	
	public static enum StatusCode {
		SUCCESS, FAILURE;
	}
	public StatusCode getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
}
