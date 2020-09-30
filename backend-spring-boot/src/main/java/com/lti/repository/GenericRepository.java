package com.lti.repository;

import org.springframework.transaction.annotation.Transactional;

public interface GenericRepository {

	<T> T save(Object object);
	<T> T fetchById(Class<T> className, int id);
}