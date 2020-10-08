package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Customer;

@Repository
public class CustomerRepositoryImpl extends GenericRepositoryImpl implements CustomerRepository {
	
	
	@Override
	public int save(Customer customer) {
		Customer updatedCustomer=entityManager.merge(customer);
		return updatedCustomer.getServiceRefNo();
	}

	@Override
	public boolean isCustomerPresent(String panCard) {
		return (Long)
				entityManager
				.createQuery("select count(c.id) from Customer c where c.panCard = :panCard")
				.setParameter("panCard", panCard)
				.getSingleResult() == 1 ?true : false;
	}

}
