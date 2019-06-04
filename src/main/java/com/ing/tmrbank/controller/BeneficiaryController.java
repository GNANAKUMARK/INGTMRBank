package com.ing.tmrbank.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path ="/api/beneficiary" )
public class BeneficiaryController {
	private static final Logger LOGGER = LogManager.getLogger(BeneficiaryController.class);

}
