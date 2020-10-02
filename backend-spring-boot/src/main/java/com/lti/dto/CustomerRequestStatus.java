package com.lti.dto;

import java.util.List;

import com.lti.entity.Customer;

public class CustomerRequestStatus extends Status {

	private List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
