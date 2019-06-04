package com.ing.tmrbank.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class SaveBeneficiaryRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	//@JsonProperty(value = "accNO")
	private Long accNO;
	private Long mobile;
	private String bankName;
	private String ifscCode;
	private Long userId;

}
