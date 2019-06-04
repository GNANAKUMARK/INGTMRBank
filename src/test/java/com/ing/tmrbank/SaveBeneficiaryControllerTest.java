package com.ing.tmrbank;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.tmrbank.controller.BeneficiaryController;
import com.ing.tmrbank.pojo.SaveBeneficiaryRequest;
import com.ing.tmrbank.pojo.SaveBeneficiaryRespone;
import com.ing.tmrbank.service.BeneficiaryService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BeneficiaryController.class, secure = false)

public class SaveBeneficiaryControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BeneficiaryService service;

	@Test
	public void saveBeneficiary() throws Exception {
		SaveBeneficiaryRequest request = new SaveBeneficiaryRequest();
		SaveBeneficiaryRespone response = new SaveBeneficiaryRespone();
		response.setId(1l);
		response.setId(1l);
		
		Mockito.when(service.saveBeneficiary(request)).thenReturn(response);
		mockMvc.perform(post("/api/beneficiaries")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(request)))
				.andExpect(status().isCreated());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
