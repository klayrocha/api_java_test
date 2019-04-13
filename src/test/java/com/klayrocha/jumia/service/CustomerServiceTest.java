package com.klayrocha.jumia.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.klayrocha.jumia.JumiaPhoneApplicationTests;
import com.klayrocha.jumia.entity.Customer;

public class CustomerServiceTest extends JumiaPhoneApplicationTests {

	@Autowired
	CustomerService customerService = null;

	@Rule
	public ExpectedException exception = ExpectedException.none();

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

	@Test
	public void findChart() {
		Object[] charts = customerService.findChart();
		assertNotNull(charts);
	}

}
