package com.klayrocha.jumia.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.klayrocha.jumia.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CustomerRepositoryTest {

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

}
