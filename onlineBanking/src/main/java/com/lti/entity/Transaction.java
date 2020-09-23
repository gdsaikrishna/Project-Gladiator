package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tranSeq")
	@SequenceGenerator(name = "tranSeq", sequenceName = "TRANSACTION_ID_SEQ", allocationSize = 1)
	@Column(name = "")
	private int transactionId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="debt_ac_no")
	private Account debitAccount; // FK
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="credit_ac_no")
	private Account creditAccount; // FK
	
	@Column(name = "tx_amount")
	private double amount;
	
	@Column(name = "tx_type")
	private String transactionType;
	
	private String remarks;
	
	@Column(name = "tx_date_time")
	private LocalDateTime transactionDateTime;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Account getDebitAccount() {
		return debitAccount;
	}

	public void setDebitAccount(Account debitAccount) {
		this.debitAccount = debitAccount;
	}

	public Account getCreditAccount() {
		return creditAccount;
	}

	public void setCreditAccount(Account creditAccount) {
		this.creditAccount = creditAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

}
