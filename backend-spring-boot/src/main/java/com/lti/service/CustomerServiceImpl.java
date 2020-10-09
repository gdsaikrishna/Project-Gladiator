package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.exception.ServiceException;
import com.lti.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmailService emailService;

	@Override
	public int register(Customer customer) {
		if (!customerRepository.isCustomerPresent(customer.getPanCard())) {
			int serviceRefNo = customerRepository.save(customer);
			emailService.sendMailForNewRegistration(customer);
			return serviceRefNo;
		} else
			throw new ServiceException("Customer already have a Savings Account");
	}

}
