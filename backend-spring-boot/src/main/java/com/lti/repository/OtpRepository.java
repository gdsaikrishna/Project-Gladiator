package com.lti.repository;

public interface OtpRepository extends GenericRepository {
	String getOtp(int userId);
}