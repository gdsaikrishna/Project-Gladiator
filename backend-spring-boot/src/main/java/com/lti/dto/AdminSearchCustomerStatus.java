package com.lti.dto;

import com.lti.entity.Customer;

public class AdminSearchCustomerStatus extends Status {

	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
