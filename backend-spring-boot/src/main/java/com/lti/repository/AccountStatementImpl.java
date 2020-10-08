package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Transaction;

@Repository
public class AccountStatementImpl extends GenericRepositoryImpl implements AccountStatement {

	@Override
	public List<Transaction> getAllRecords(int accNumber) {
		return(List<Transaction>)
				entityManager
				.createQuery("select t from Transaction t where t.debitAccount.accountNumber =:accNumber or t.creditAccount.accountNumber=:accNumber")
                .setParameter("accNumber", accNumber)
                .getResultList();
	}

	@Override
	public List<Transaction> getAccountHistory(int accNumber) {
		return(List<Transaction>)
		       entityManager
		      .createQuery("select t from Transaction t where (t.fromAccountNumber=:accNumber or t.toAccountNumber=:accNumber) and t.transactionDate between :fromDate and :toDate")
		      .setParameter("accNumber", accNumber)
		      .getResultList();
		
		
	}
	
	

}
