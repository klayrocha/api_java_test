package com.klayrocha.jumia.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.klayrocha.jumia.JumiaPhoneApplicationTests;
import com.klayrocha.jumia.entity.Customer;

public class CustomerRepositoryTest extends JumiaPhoneApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void findByCountry() {
		Pageable pages = PageRequest.of(0, 41);
		Page<Customer> customers = customerRepository.findByCountry(pages, "212");
		assertEquals(7, customers.getTotalElements());
	}

	@Test
	public void findAllOrderByCountry() {
		Pageable pages = PageRequest.of(0, 41);
		Page<Customer> customers = customerRepository.findAllOrderByCountry(pages);
		assertEquals(41, customers.getTotalElements());
	}

	@Test
	public void findChart() {
		Object[] charts = customerRepository.findChart();
		assertNotNull(charts);
	}

}
