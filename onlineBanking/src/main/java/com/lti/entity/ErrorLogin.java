package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "table_error_login")
public class ErrorLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "errSeq")
	@SequenceGenerator(name = "errSeq", sequenceName = "ERR_LOGIN_LOG_ID_SEQ", allocationSize = 1)
	private int errLoginLogId;
	private User user;
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
