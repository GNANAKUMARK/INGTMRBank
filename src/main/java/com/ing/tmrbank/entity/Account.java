package com.ing.tmrbank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account implements Serializable {
	

	public Account(Integer id, String firstName, String lastName, Long mobile, String userName, String pan,
			String password, String accountType, Double balance, String status, String updatedBy, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.userName = userName;
		this.pan = pan;
		this.password = password;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.updatedBy = updatedBy;
		this.emailId = emailId;
	}

	public Account() {
		super();
	}



	public Account(Integer id, String firstName, String lastName, String userName, String password, String accountType,
			Double balance, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.accountType = accountType;
		this.balance = balance;
		this.emailId = emailId;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column(name="FirstName")
	String firstName;

	@Column(name="LastName")
	String lastName;
	
	@Column(name="Mobile")
	Long mobile;
	
	@Column(name="UserName")
	String userName;
	
	@Column(name="PAN")
	String pan;
	
	@Column(name="Password")
	String password;
	//
	//String card;
	@Column(name="AccType")
	String accountType;
	
	@Column(name="Balance")
	Double balance;
	
	@Column(name="Status")
	String status;
	
	@Column(name="UpdatedBy")
	String updatedBy;
	
	@Column(name="emailID")
	String emailId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public Account(Integer id, String firstName, String lastName, long mobile, String userName, String pan,
			String password, String accountType, double balance, String status, String updatedBy, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.userName = userName;
		this.pan = pan;
		this.password = password;
		this.accountType = accountType;
		this.balance = balance;
		this.status = status;
		this.updatedBy = updatedBy;
		this.emailId = emailId;
	}


}
