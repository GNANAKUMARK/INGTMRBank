package com.ing.tmrbank;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.tmrbank.dao.BeneficiaryRepository;
import com.ing.tmrbank.entity.Beneficiary;
import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;
import com.ing.tmrbank.service.BeneficiaryServiceImpl;

@RunWith(SpringRunner.class)
//@RunWith(PowerMockRunner.class)
@SpringBootTest

public class SaveBeneficiaryServiceTest {
	@Mock
	BeneficiaryRepository  repo;
	
	@InjectMocks
	BeneficiaryServiceImpl service;
	
	//@SuppressWarnings("deprecation")
	@Test
	public void saveBeneficiaries() {
		Beneficiary beneficiary = new Beneficiary();
		SaveBeneficiaryRequest request = new SaveBeneficiaryRequest();
		SaveBeneficiaryRespone response = new SaveBeneficiaryRespone();
		beneficiary.setId(1l);
		response.setId(1l);
		Mockito.when(repo.save(Matchers.anyObject())).thenReturn(beneficiary);
		//PowerMockito.
		response = service.saveBeneficiary(request);
		assertNotNull(response.getId());
		
	}

}
