package com.lti.repository;

import com.lti.entity.User;

public interface UserRepository extends GenericRepository {

	boolean isUserExists(int id);

	User fetchUserWithUserIdAndPassword(int id, String password);
	User fetchUserWithUserId(int id);
	String fetchUserTransactionPassword(int id);
	

}