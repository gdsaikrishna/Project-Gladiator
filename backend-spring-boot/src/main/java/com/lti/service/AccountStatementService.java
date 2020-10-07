package com.lti.service;

import java.util.List;

import com.lti.dto.StatementTransactionDto;
import com.lti.entity.Transaction;

public interface AccountStatementService {
	
	public List<StatementTransactionDto> accountStatment(int userId);
	public List<StatementTransactionDto> accountHistory(int userId);

}
