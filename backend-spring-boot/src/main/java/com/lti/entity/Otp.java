package com.lti.entity;

import java.time.LocalDateTime;

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
	
	@Column(name="date_time")
	private LocalDateTime dateTime;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

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
