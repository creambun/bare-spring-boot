package com.example.demo.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class TestUoaRESTController {
	@Autowired
	private MockMvc mvc;

	@Test
	public void testGetAllUoas() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/api/uoas").accept(MediaType.APPLICATION_JSON)
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").exists())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$.length()", is(3)))
		.andExpect(jsonPath("$[?(@.code == 'USD')]").exists())
		.andExpect(jsonPath("$[?(@.code == 'GBP')]").exists())
		.andExpect(jsonPath("$[?(@.code == 'BARREL')]").exists())
		.andExpect(jsonPath("$[?(@.code == 'HKD')]").doesNotExist())
		;
	}

}
