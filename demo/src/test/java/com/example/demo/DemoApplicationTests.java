package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.aspectj.lang.annotation.Before;

import static com.example.Main.*;

import org.jboss.jandex.Main;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(DemoController.class)
class DemoApplicationTests {

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired 
	MockMvc mockMvc;
	//@Test//commented for others test
	void mainTest() {
		//Redirigir salida 
		Main principle = mock(Main.class);
		String  args[] ={};
		Main.main(args);
		verify(principle,times(10));
		Main.main(args);
	}

	@Test
	void fiboTest() {
		assertEquals(fibonacciIterativo(10), calcularFibonacci(10));
	}

	ObjectMapper mapper;
	
	@MockBean
	DemoService service;
	@Test
	public void postTest() throws Exception{
		mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();	
		mapper = new ObjectMapper();
		DemoEntity demo = new DemoEntity();
		demo.setDemoName("nameTest");
		demo.setId(23l);
		mockMvc.perform(post("/demo").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(demo))).andExpect(status().isNotFound())
		.andDo(MockMvcResultHandlers.log());
	}


	@Test
	public void getTest() throws Exception{
		mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();	
		mapper = new ObjectMapper();
		mockMvc.perform(get("/demo/get").param("id", "2").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound())
		.andDo(MockMvcResultHandlers.log());
	}

	@Test
	public void deleteTest() throws Exception{
		mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();	
		mapper = new ObjectMapper();
		mockMvc.perform(delete("/demo/").param("id", "2").contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound())
		.andDo(MockMvcResultHandlers.log());
	}

}
