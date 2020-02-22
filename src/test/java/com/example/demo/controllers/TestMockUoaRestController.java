package com.example.demo.controllers;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.models.Uoa;
import com.example.demo.models.UoaStatus;
import com.example.demo.models.UoaType;
import com.example.demo.service.UoaService;

import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TestMockUoaRestController {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UoaService uoaService;
	
	@Test
	public void getCAD_shouldReturnOk() throws Exception {
		doReturn(Uoa.builder().code("CAD").type(UoaType.Equity).status(UoaStatus.Deleted).build())
			.when(uoaService).getUoa("CAD")
			;
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/uoas/CAD").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.code", is("CAD")))
			;
	}
}
