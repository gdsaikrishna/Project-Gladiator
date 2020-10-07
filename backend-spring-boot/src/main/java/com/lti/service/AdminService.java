package com.lti.service;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Customer;

public interface AdminService {

	Admin login(int id, String password);
	List<Customer> getPendingRequests();
	void updatePendingRequests(int serviceRefNo, String response);
	Customer searchCustomerByServRefNo(int servRefNo);
}