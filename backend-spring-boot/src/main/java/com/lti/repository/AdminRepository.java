package com.lti.repository;

import com.lti.entity.Admin;

public interface AdminRepository {

	boolean exists(int adminId);
	Admin fetchByIdAndPassword(int adminId, String pwd);
}