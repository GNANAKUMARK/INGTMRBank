package com.ing.tmrbank.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class SaveBeneficiaryRespone implements Serializable {
	private String status;
	private Long id;


}
