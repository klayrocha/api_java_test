package com.klayrocha.jumia.controller;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.klayrocha.jumia.JumiaPhoneApplicationTests;
import com.klayrocha.jumia.response.Response;

public class PhoneControllerTest extends JumiaPhoneApplicationTests {

	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testfindAll() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/phone/0/10").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testfindAllAmount() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/phone/0/41").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		ObjectMapper objectMapper = new ObjectMapper();
		Response response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Response.class);
		LinkedHashMap lhm = (LinkedHashMap) response.getData();
		Integer totalElements = (Integer) lhm.get("totalElements");
		assertEquals(41, totalElements.intValue());
	}

	@Test
	public void testfindAllInternalError() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/phone/0/XX").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		ObjectMapper objectMapper = new ObjectMapper();
		ErrorTest erros = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ErrorTest.class);
		assertEquals("Internal Error, please contact the system administrator", erros.getMessage());
	}

	@Test
	public void testFindByCountryState() throws Exception {
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.get("/api/phone/0/41/212/Valid").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void testFindCountries() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/phone/countries").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void testFindChart() throws Exception {
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/api/phone/chart").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

}
