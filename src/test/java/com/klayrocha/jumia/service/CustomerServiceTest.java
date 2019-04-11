package com.klayrocha.jumia.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.klayrocha.jumia.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService = null;

	@Test
	public void testCountries() {
		assertNotNull(customerService.findCountries());
	}

	@Test
	public void testfindAll() {
		Page<Customer> customers = customerService.findAll(0, 41);
		assertEquals(41, customers.getTotalElements());
	}

	@Test
	public void findByCountryStateCode251Invalid() {
		Page<Customer> customers = customerService.findByCountryState(0, 41, "251", "Invalid");
		assertEquals(2, customers.getTotalElements());
	}

	@Test
	public void findByCountryStateCode251Valid() {
		Page<Customer> customers = customerService.findByCountryState(0, 41, "251", "Valid");
		assertEquals(7, customers.getTotalElements());
	}
	
	@Test
	public void findByCountryStateCode251Uninformed() {
		Page<Customer> customers = customerService.findByCountryState(0, 41, "251", "uninformed");
		assertEquals(9, customers.getTotalElements());
	}

}
