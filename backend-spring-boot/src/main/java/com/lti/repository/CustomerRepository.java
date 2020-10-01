package com.lti.repository;

import com.lti.entity.Customer;

public interface CustomerRepository extends GenericRepository{

	int save(Customer customer);
	
	boolean isCustomerPresent(String panCard);
}