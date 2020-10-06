package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_otp")
public class Otp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "otpSeq")
	@SequenceGenerator(name = "otpSeq", sequenceName = "Otp_SEQ", allocationSize = 1)
	@Column(name="otp_id")
	private int id;
	
	private String otp;
	
	@Column(name="user_id")
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
