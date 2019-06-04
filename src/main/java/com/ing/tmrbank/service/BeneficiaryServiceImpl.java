package com.ing.tmrbank.service;

import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.tmrbank.dao.BeneficiaryRepository;
import com.ing.tmrbank.dao.UserDao;
import com.ing.tmrbank.entity.Beneficiary;
import com.ing.tmrbank.exception.DataNotFoundException;
import com.ing.tmrbank.pojo.BeneficiaryDetails;
import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;
import com.ing.tmrbank.pojo.SaveOtpRequest;
import com.ing.tmrbank.utils.MailService;
import com.ing.tmrbank.utils.UtilConstants;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

	private static final Logger LOGGER = LogManager.getLogger(BeneficiaryServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Autowired
	MailService mailService;

	@Override
	public SaveBeneficiaryRespone saveBeneficiary(SaveBeneficiaryRequest request) {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setName(request.getName());
		beneficiary.setBankName(request.getBankName());
		beneficiary.setIfscCode(request.getIfscCode());
		beneficiary.setMobile(request.getMobile());
		beneficiary.setAccNO(request.getAccountNo());
		beneficiary.setUserId(request.getUserId());
		Random random = new Random();
		long otp = 100000 + random.nextInt(900000);
		beneficiary.setOtp(otp);

		beneficiary = beneficiaryRepository.save(beneficiary);

		
		/*
		 * try { //Account account =
		 * userDao.findById(request.getUserId().intValue()).orElse(null);
		 * //mailService.sendOTPEmail(account.getEmailId(), otp); } catch(Exception e) {
		 * 
		 * }
		 */
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

	@Override
	public boolean validateOtp(SaveOtpRequest request) {
		Beneficiary beneficiary = beneficiaryRepository.findById(request.getId()).orElse(null);
		if (beneficiary == null) {
			throw new DataNotFoundException("Invalid Payee details");
		}
		if (beneficiary.getOtp() != null && beneficiary.getOtp().equals(request.getOtp())) {
			return true;
		}
		return false;
	}

	public void deleteBeneficiary(Long id) {
		beneficiaryRepository.deleteById(id);
	}
	
	@Override
    public Beneficiary updateDetails(long id, SaveBeneficiaryRequest request) {
        Beneficiary beneficiary = new Beneficiary();
        BeanUtils.copyProperties(request,beneficiary);
        beneficiary.setId(id);
        return beneficiaryRepository.save(beneficiary);
    
    }
}
