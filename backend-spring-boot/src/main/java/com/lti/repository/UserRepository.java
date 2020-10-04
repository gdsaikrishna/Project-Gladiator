package com.lti.repository;

import com.lti.entity.User;

public interface UserRepository extends GenericRepository {

	boolean isUserExists(int id);

	User fetchUserWithUserIdAndPassword(int id, String password);
	
	String fetchUserTransactionPassword(int id);

}