package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class GenericDaoImpl implements GenericDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional
	public <T> T save(Object obj) {
		return (T) entityManager.merge(obj);
	}
	
	public <T> T fetchById(Class<T> clazz, Object id) {
		return entityManager.find(clazz, id);
	}

}
