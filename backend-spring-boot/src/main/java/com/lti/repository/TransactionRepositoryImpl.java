package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.lti.entity.Transaction;

@Transactional
public abstract class TransactionRepositoryImpl implements TransactionRepository{
	@PersistenceContext
	private EntityManager em;
	@Override
	public boolean isTransactionPresent() {
		return(Long)em.createQuery("isTableEmpty").getSingleResult()==0 ? true:false;
		
	}
	
	@Override
	public void save(Transaction transaction) {
		em.persist(transaction);
	}
	@Override
	public void getTransactionId() {
		em.createQuery("getTransactionId").getSingleResult();
		
	}
	@Override
	public List<Transaction> getTransactionBetweenDates(String fromDate, String toDate, String accountNumber) {
		System.out.println(fromDate);
		System.out.println(toDate);
		System.out.println(accountNumber);
		return (List<Transaction>) em.createQuery("transactionHistory").setParameter("accNumber", accountNumber).setParameter("fromDate", fromDate).setParameter("toDate", toDate).getSingleResult();
		
		
	}
         		
	
	
	
	
	
	

}
