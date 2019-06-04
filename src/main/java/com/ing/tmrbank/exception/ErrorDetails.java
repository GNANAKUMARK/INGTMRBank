package com.ing.tmrbank.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ErrorDetails {
	private String message;
	@JsonIgnore
	private String details;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorDetails(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	

}
