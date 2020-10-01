package com.lti.entity;

import java.time.LocalDate;

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
@Table(name = "table_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSeq")
	@SequenceGenerator(name = "custSeq", sequenceName = "CUSTOMER_SERVICE_REF_NO_SEQ", allocationSize = 11)
	@Column(name="service_ref_no")
	private int serviceRefNo;
	
	private String title;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="mobile_no")
	private String mobileNo;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="aadhaar_card_no")
	private String aadhaarNo;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="occupation_type")
	private String occupationType;
	
	@Column(name="source_of_income")
	private String sourceOfIncome;
	
	@Column(name="gross_annual_income")
	private float grossAnnualIncome;
	
	@Column(name="debit_card_requirement")
	private String debitCardRequirement;
	
	@Column(name="net_banking_requirement")
	private String netBankingRequirement;
	
	@Column(name="is_approved")
	private String isApproved;
	
	@Column(name="pan_card")
	private String panCard;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "res_address_id")
	private Address resAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "per_address_id")
	private Address perAddress;

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

	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAadhaarNo() {
		return aadhaarNo;
	}

	public void setAadhaarNo(String aadhaarNo) {
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
