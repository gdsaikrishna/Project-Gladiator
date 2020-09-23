package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDao {
	public <T> T save(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		T updatedObj = null;
		try {
			emf = Persistence.createEntityManagerFactory("OnlineBanking");
			em = emf.createEntityManager();

			EntityTransaction tx = em.getTransaction();
			tx.begin();
			updatedObj = (T) em.merge(obj);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return updatedObj;
	}

	public <T> T fetchById(Class<T> className, Object id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;

		T obj = null;
		try {
			emf = Persistence.createEntityManagerFactory("OnlineBanking");
			em = emf.createEntityManager();

			obj = em.find(className, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return obj;
	}
}
