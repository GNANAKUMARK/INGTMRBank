package com.ing.tmrbank.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public
class BeneficiaryDetails implements Serializable {
	/** * */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Long accountNo;
	private Long mobile;
	private String bankName;
	private String ifscCode;
	private String status;

	public BeneficiaryDetails(Long id, String name, Long accountNo, Long mobile, String bankName, String ifscCode,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.accountNo = accountNo;
		this.mobile = mobile;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.status = status;
	}
}