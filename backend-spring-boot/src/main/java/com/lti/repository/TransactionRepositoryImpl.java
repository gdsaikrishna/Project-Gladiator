package com.lti.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.Transaction;

@Repository
public class TransactionRepositoryImpl extends GenericRepositoryImpl implements TransactionRepository{
	
	@Transactional
	public Transaction fetchTransactionObjectAfterSaving(Transaction transaction) {
		Transaction updatedTransaction=(Transaction)entityManager.merge(transaction);
		return updatedTransaction;
	}
}
