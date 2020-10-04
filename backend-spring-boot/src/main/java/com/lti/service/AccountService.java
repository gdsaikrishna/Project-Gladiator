package com.lti.service;

import java.util.List;

import com.lti.entity.Account;

public interface AccountService {

	List<Account> fetchAccountSummary(int id);

}