package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericRepositoryImpl implements GenericRepository {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	@Transactional
	public <T> T save(Object object) {
		return (T) entityManager.merge(object);
	}

	@Override
	public <T> T fetchById(Class<T> className, int id) {
		return entityManager.find(className, id);
	}
	
}
