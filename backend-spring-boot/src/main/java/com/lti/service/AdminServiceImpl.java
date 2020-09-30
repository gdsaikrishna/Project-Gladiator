package com.lti.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Admin;
import com.lti.exception.ServiceException;
import com.lti.repository.AdminRepository;

@Service
@Transactional
public class AdminServiceImpl {

	@Autowired
	private AdminRepository repository;

	private Admin login(int id, String password) {
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

}
