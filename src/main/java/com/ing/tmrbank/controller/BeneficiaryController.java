package com.ing.tmrbank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;
import com.ing.tmrbank.service.BeneficiaryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class BeneficiaryController {
	private static final Logger LOGGER = LogManager.getLogger(BeneficiaryController.class);
	@Autowired
	BeneficiaryService beneficiaryService;

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

}
