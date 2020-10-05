package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.Account;
import com.lti.entity.User;
import com.lti.exception.ServiceException;
import com.lti.repository.AccountRepository;

@Service
public class AccountSummaryServiceImpl implements AccountSummaryService {

	@Autowired
	private AccountRepository repository;
	
	@Override
	public List<Account> fetchAccountSummary(int id) {
		try {
			User user = repository.fetchById(User.class, id);
			List<Account> accounts = user.getAccounts();
			return accounts;
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("User not found");
		}
	}
}
