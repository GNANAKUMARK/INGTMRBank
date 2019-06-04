package com.ing.tmrbank.pojo;

import java.io.Serializable;

public class SaveOtpRequest implements Serializable {
	private long id;
	private Long otp;
	private String operType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}
}