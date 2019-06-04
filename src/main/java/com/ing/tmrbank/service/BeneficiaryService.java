package com.ing.tmrbank.service;

import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;

public interface BeneficiaryService {
	
	SaveBeneficiaryRespone saveBeneficiary (SaveBeneficiaryRequest request);

}
