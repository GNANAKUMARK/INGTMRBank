package com.ing.tmrbank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Beneficiary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Acc_No")
	private Long accNO;

	@Column(name = "Mobile")
	private Long mobile;

	@Column(name = "Bank_Name")
	private String bankName;

	@Column(name = "IFSC_Code")
	private String ifscCode;

	@Column(name = "Status")
	private String status;

	@Column(name = "User_Id")
	private Long userId;

	private String Otp;

}
