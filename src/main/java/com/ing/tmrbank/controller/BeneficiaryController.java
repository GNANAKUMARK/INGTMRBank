package com.ing.tmrbank.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.tmrbank.entity.Beneficiary;
import com.ing.tmrbank.exception.DataNotFoundException;
import com.ing.tmrbank.pojo.BeneficiaryDetails;
import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;
import com.ing.tmrbank.pojo.SaveOtpRequest;
import com.ing.tmrbank.service.BeneficiaryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class BeneficiaryController {
	private static final Logger LOGGER = LogManager.getLogger(BeneficiaryController.class);
	@Autowired
	BeneficiaryService beneficiaryService;
	
	private String ABC="";

	private String test = null;
	@PostMapping(value = "/beneficiaries")
	public ResponseEntity<SaveBeneficiaryRespone> saveBeneficiary(@RequestBody SaveBeneficiaryRequest request) {
		SaveBeneficiaryRespone response = null;
		try {
			
			response = beneficiaryService.saveBeneficiary(request);
			
		} catch (Exception e) {
			LOGGER.error(e);
			throw e;
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	@GetMapping("/beneficiaries/{userId}")
	public ResponseEntity<List<BeneficiaryDetails>> listBeneficiaries(
			@PathVariable(name = "userId", required = false) Long userId) {
		LOGGER.info("inside BeneficiaryController listBeneficiaries()");
		LOGGER.info("userId : " + userId);
		List<BeneficiaryDetails> beneficiaryDetailsList = beneficiaryService.getAllBeneficiaries(userId);
		LOGGER.info("status updated");
		return new ResponseEntity<>(beneficiaryDetailsList, HttpStatus.OK);
	}

	
	@PostMapping("/validate")
	public ResponseEntity<SaveBeneficiaryRespone> validateOtp(@RequestBody SaveOtpRequest request)
			throws DataNotFoundException {
		LOGGER.info("Enter SampleController::test");
		LOGGER.debug("in side test method");
		Beneficiary beneficiary = new Beneficiary();
		SaveBeneficiaryRespone response = new SaveBeneficiaryRespone();
		boolean benef = beneficiaryService.validateOtp(request);
		if (!benef) {
			throw new DataNotFoundException("Enter valid OTP !!!");
		}
		response.setStatus("OTP Verified");
		return new ResponseEntity<SaveBeneficiaryRespone>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/beneficiaries/{id}")
	public ResponseEntity<SaveBeneficiaryRespone> deleteBeneficiary(
			@PathVariable(name = "id", required = false) Long id) {
		SaveBeneficiaryRespone response = new SaveBeneficiaryRespone();
		try {
			beneficiaryService.deleteBeneficiary(id);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new DataNotFoundException("Payee is not exist"); 
		}
		response.setId(id);
		response.setStatus("Payee has been deleted successfully"); 
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SaveBeneficiaryRespone> updateBeneficiaryDetail(@PathVariable("id") long id,@RequestBody SaveBeneficiaryRequest request)
            throws DataNotFoundException{
        LOGGER.info("Enter SampleController::test");
        LOGGER.debug("in side test method");
        SaveBeneficiaryRespone response = new SaveBeneficiaryRespone();
        Beneficiary beneficiary = beneficiaryService.updateDetails(id,request);
        if(beneficiary==null || beneficiary.getId()==null) {
            throw new DataNotFoundException("data not found");
        }
        response.setStatus("Updated Successfully");
        return new ResponseEntity<SaveBeneficiaryRespone>(response,HttpStatus.OK);
        
    }
}
