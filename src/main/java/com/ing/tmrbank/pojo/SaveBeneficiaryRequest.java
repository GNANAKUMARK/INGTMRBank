package com.ing.tmrbank.pojo;

import java.io.Serializable;

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
	private Long accountNo;
	private Long mobile;
	private String bankName;
	private String ifscCode;
	private Long userId;

}
