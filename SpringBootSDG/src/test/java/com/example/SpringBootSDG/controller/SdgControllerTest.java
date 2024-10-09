package com.example.SpringBootSDG.controller;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.SpringBootSDG.service.SdgService;

@SpringBootTest
public class SdgControllerTest {
	
	@MockBean
	private SdgService sdgService;
	
	 
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mvc;
	
	@BeforeEach
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void getAllCountriesTest() throws Exception {

		mvc.perform(MockMvcRequestBuilders
				.post("/api/v1/data/country")
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
		      	.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
		      	.andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void updateCountry() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders
				.post("/api/v1/data/country")
			    .contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
		      	.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
		      	.andDo(MockMvcResultHandlers.print());
	}
	
}
