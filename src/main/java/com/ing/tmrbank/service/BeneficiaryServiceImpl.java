package com.ing.tmrbank.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.tmrbank.dao.BeneficiaryRepository;
import com.ing.tmrbank.entity.Beneficiary;
import com.ing.tmrbank.exception.DataNotFoundException;
import com.ing.tmrbank.pojo.BeneficiaryDetails;
import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;
import com.ing.tmrbank.utils.UtilConstants;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	private static final Logger LOGGER = LogManager.getLogger(BeneficiaryServiceImpl.class);
	
	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Override
	public SaveBeneficiaryRespone saveBeneficiary(SaveBeneficiaryRequest request) {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setName(request.getName());
		beneficiary.setBankName(request.getBankName());
		beneficiary.setIfscCode(request.getIfscCode());
		beneficiary.setMobile(request.getMobile());
		beneficiary.setAccNO(request.getAccountNo());
		beneficiary.setUserId(request.getUserId());
		beneficiary = beneficiaryRepository.save(beneficiary);
		SaveBeneficiaryRespone response = new SaveBeneficiaryRespone();
		response.setStatus(UtilConstants.SUCCESS_STATUS);
		response.setId(beneficiary.getId());
		return response;
	}

	@Override
	public List<BeneficiaryDetails> getAllBeneficiaries(Long userId) {
		LOGGER.info("userId : " + userId);
		List<BeneficiaryDetails> beneficiaryDetailsListList = beneficiaryRepository.getAllBeneficiaries(userId);
		if (beneficiaryDetailsListList.isEmpty()) {
			LOGGER.error("No data found in the system for the requested user");
			throw new DataNotFoundException("No data found in the system for the requested user");
		}
		return beneficiaryDetailsListList;
	}
}
