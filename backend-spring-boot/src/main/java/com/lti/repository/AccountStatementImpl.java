package com.lti.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Transaction;

@Repository
public class AccountStatementImpl extends GenericRepositoryImpl implements AccountStatement {

	@Override
	public List<Transaction> getAllRecords(int accNumber,LocalDate fromDate,LocalDate toDate) {
		System.out.println("Asili");
		return(List<Transaction>)
				entityManager
				.createQuery("select t from Transaction t where (t.debitAccount.accountNumber=:accountNumber or t.creditAccount.accountNumber=:accountNumber) and t.transactionDateTime between to_date(:fromDate) and to_date(:toDate)",Transaction.class)
                .setParameter("accountNumber", accNumber)
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
	}

		
	
	

}
