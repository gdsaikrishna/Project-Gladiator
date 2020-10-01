package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.exception.ServiceException;
import com.lti.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repository;

	@Override
	public Admin login(int id, String password) {
		try {
			if (!repository.exists(id))
				throw new ServiceException("Invalid admin id/password");
			else {
				if (repository.fetchByIdAndPassword(id, password) == null)
					throw new ServiceException("Incorrect admin password");
				else
					return repository.fetchByIdAndPassword(id, password);
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid admin id/password");
		}
	}

	@Override
	public List<Customer> getPendingRequests(){
		if(repository.fetchPendingRequests().size() >= 1)
			return repository.fetchPendingRequests();
		else
			throw new ServiceException("No pending requests");
	}
	
	@Override
	public void updatePendingRequests(int serviceRefNo, String response) {
		Customer customer=repository.fetchById(Customer.class, serviceRefNo);
			if(customer != null) {
				customer.setIsApproved(response);
				repository.save(customer);
			}
			else
				throw new ServiceException("Invalid response from admin. No such customer");
	}
}
