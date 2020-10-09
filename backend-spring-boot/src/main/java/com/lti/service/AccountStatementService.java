package com.lti.service;

import java.util.List;

import com.lti.dto.StatementDuration;
import com.lti.dto.StatementTransactionDto;

public interface AccountStatementService {
	
	List<StatementTransactionDto> accountStatment(StatementDuration statementDuration);

}
