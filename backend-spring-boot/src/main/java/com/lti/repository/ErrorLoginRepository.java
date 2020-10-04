package com.lti.repository;

public interface ErrorLoginRepository extends GenericRepository{

	boolean checkErrorLoginCount(int userId);

}