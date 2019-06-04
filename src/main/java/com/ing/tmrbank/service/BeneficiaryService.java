package com.ing.tmrbank.service;

import java.util.List;

import com.ing.tmrbank.pojo.BeneficiaryDetails;
import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;
import com.ing.tmrbank.pojo.SaveOtpRequest;

public interface BeneficiaryService {

	SaveBeneficiaryRespone saveBeneficiary(SaveBeneficiaryRequest request);

	List<BeneficiaryDetails> getAllBeneficiaries(Long userId);
	
	boolean validateOtp(SaveOtpRequest request);
}
