package com.example.demo;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UoaService uoaService;
	
	@Test
	public void givenAllUoas_getAll_shouldReturnList() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/uoas").accept(MediaType.APPLICATION_JSON)
		)
		.andDo(print())
		.andExpect(status().isOk())
		;
	}
	
	@Test
	public void getUSD_shouldReturnOk() throws Exception {
		doReturn(Uoa.builder().code("USD").type(UoaType.Currency).status(UoaStatus.Active).build())
			.when(uoaService).getUoa("USD")
			;
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/uoas/USD").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isOk())
			;
	}
	
	@Test
	public void getHKD_shouldReturn404() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/uoas/HKD").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isNotFound())
			;
	}
}
