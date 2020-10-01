package com.lti.dto;

public class OpenAccStatus {
	
	private boolean status;
	private String statusMessage;
	private int serviceRefNo;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public int getServiceRefNo() {
		return serviceRefNo;
	}
	public void setServiceRefNo(int serviceRefNo) {
		this.serviceRefNo = serviceRefNo;
	}
	

}
