package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "table_error_login")
public class ErrorLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "errSeq")
	@SequenceGenerator(name = "errSeq", sequenceName = "ERR_LOGIN_LOG_ID_SEQ", allocationSize = 1)
	@Column(name = "err_login_id")
	private int errLoginLogId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "date_and_time")
	private LocalDateTime dateAndTime;

	public int getErrLoginLogId() {
		return errLoginLogId;
	}

	public void setErrLoginLogId(int errLoginLogId) {
		this.errLoginLogId = errLoginLogId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(LocalDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

}
