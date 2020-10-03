package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Customer;
import com.lti.exception.ServiceException;
import com.lti.repository.TrackApplicationRepository;

@Service
@Transactional
public class TrackApplicationServiceImpl implements TrackApplicationService {

	@Autowired
	private TrackApplicationRepository repository;

	@Override
	public String fetchStatus(int serviceRefNo) {
		try {
			Customer customer = repository.fetchById(Customer.class, serviceRefNo);
			return customer.getIsApproved();
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid customer service ref no.");
		}
	}
}
