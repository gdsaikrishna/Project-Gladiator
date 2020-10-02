package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.entity.Customer;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.AdminRepository;
import com.lti.repository.CustomerRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Admin login(int id, String password) {
		try {
			if (!repository.exists(id))
				throw new ServiceException("Invalid admin id/password");
			else {
				Admin admin = repository.fetchById(Admin.class, id);
				if (repository.fetchByIdAndPassword(admin.getId(), admin.getPassword()) != null)
					return repository.fetchByIdAndPassword(id, password);
				else
					throw new ServiceException("Incorrect password");
			}
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid admin id/password");
		}
	}

	@Override
	public List<Customer> getPendingRequests() {
		if (repository.fetchPendingRequests().size() >= 1)
			return repository.fetchPendingRequests();
		else
			throw new ServiceException("No pending requests");
	}

	@Override
	public void updatePendingRequests(int serviceRefNo, String response) {
		Customer customer = repository.fetchById(Customer.class, serviceRefNo);
		if (customerRepository.isCustomerPresent(customer.getPanCard())) {
			customer.setIsApproved(response);
			repository.save(customer);
			Customer updatedCustomer = repository.fetchById(Customer.class, serviceRefNo);

			User user = new User();
			user.setCustomer(updatedCustomer);
			user.setId(400004); // this will be auto-generated
			repository.save(user);
		} else
			throw new ServiceException("Invalid response from admin, no such customer");
	}
}
