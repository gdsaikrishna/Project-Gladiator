package com.lti.repository;


public interface GenericRepository {

	<T> T save(Object object);
	<T> T fetchById(Class<T> className, int id);
}