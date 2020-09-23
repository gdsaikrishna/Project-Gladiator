package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSeq")
	@SequenceGenerator(name = "custSeq", sequenceName = "CUSTOMER_SERVICE_REF_NO_SEQ", allocationSize = 11)
	private int serviceRefNo;
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String fatherName;
	private long mobileNo;
	private String emailId;
	private long aadhaarNo;
	private LocalDate dateOfBirth;
	private String occupationType;
	private String sourceOfIncome;
	private float grossAnnualIncome;
	private String debitCardRequirement;
	private String netBankingRequirement;
	private String isApproved;
	private String panCard;
	
	@OneToOne
	@JoinColumn(name = "res_address_id")
	private Address resAddress; //fk
	
	@OneToOne
	@JoinColumn(name = "per_address_id")
	private Address perAddress; //fk

	public int getServiceRefNo() {
		return serviceRefNo;
	}

	public void setServiceRefNo(int serviceRefNo) {
		this.serviceRefNo = serviceRefNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(long aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getSourceOfIncome() {
		return sourceOfIncome;
	}

	public void setSourceOfIncome(String sourceOfIncome) {
		this.sourceOfIncome = sourceOfIncome;
	}

	public float getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(float grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getDebitCardRequirement() {
		return debitCardRequirement;
	}

	public void setDebitCardRequirement(String debitCardRequirement) {
		this.debitCardRequirement = debitCardRequirement;
	}

	public String getNetBankingRequirement() {
		return netBankingRequirement;
	}

	public void setNetBankingRequirement(String netBankingRequirement) {
		this.netBankingRequirement = netBankingRequirement;
	}

	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public Address getResAddress() {
		return resAddress;
	}

	public void setResAddress(Address resAddress) {
		this.resAddress = resAddress;
	}

	public Address getPerAddress() {
		return perAddress;
	}

	public void setPerAddress(Address perAddress) {
		this.perAddress = perAddress;
	}

}
