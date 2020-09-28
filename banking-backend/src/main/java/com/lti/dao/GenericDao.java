package com.lti.dao;

import javax.transaction.Transactional;

public interface GenericDao {

	<T> T save(Object obj);

	<T> T fetchById(Class<T> clazz, Object id);

}