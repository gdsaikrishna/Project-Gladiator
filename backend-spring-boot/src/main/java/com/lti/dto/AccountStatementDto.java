package com.lti.dto;

import java.util.List;

public class AccountStatementDto extends Status{
	private List<StatementTransactionDto> StatementTransactionDto;

	public List<StatementTransactionDto> getStatementTransactionDto() {
		return StatementTransactionDto;
	}

	public void setStatementTransactionDto(List<StatementTransactionDto> statementTransactionDto) {
		StatementTransactionDto = statementTransactionDto;
	}
	

}
