package com.lti.repository;

import java.util.List;

import com.lti.entity.Admin;
import com.lti.entity.Customer;

public interface AdminRepository extends GenericRepository {

	boolean exists(int adminId);
	Admin fetchByIdAndPassword(int adminId, String pwd);
	List<Customer> fetchPendingRequests();
}