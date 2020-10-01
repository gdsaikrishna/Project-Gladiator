package com.lti.service;

import com.lti.entity.User;

public interface UserService {

	User login(int id, String password);

}