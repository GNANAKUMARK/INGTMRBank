package com.ing.tmrbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.tmrbank.dao.BeneficiaryRepository;
import com.ing.tmrbank.entity.Beneficiary;
import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	@Autowired 
	BeneficiaryRepository beneficiaryRepository;
	@Override
	public SaveBeneficiaryRespone saveBeneficiary(SaveBeneficiaryRequest request) {
		Beneficiary  beneficiary = new Beneficiary();
		//beneficiary.
		beneficiary = beneficiaryRepository.save(beneficiary);
		SaveBeneficiaryRespone response = new SaveBeneficiaryRespone();
		return response;
	}

}
