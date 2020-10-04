package com.lti.service;

import com.lti.entity.Customer;

public interface UserProfileService {

	Customer fetchProfile(int id);
}