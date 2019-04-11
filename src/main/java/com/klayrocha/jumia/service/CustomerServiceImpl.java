package com.klayrocha.jumia.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klayrocha.jumia.entity.Country;
import com.klayrocha.jumia.entity.Customer;
import com.klayrocha.jumia.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Page<Customer> findAll(int page, int count) {
		Pageable pages = PageRequest.of(page, count);
		return this.customerRepository.findAllOrderByCountry(pages);
	}

	@Override
	public Page<Customer> findByCountry(int page, int count, String countryCode,String state) {
		// TODO IMPLEMENTS FILTERS
		Pageable pages = PageRequest.of(page, count);
		return this.customerRepository.findByCountry(pages, countryCode);
	}

	@Override
	public List<Country> findCountries() {
		List<Country> countries = Arrays.asList(new Country(237, "Cameroon"), new Country(251, "Ethiopia"),
				new Country(212, "Morocco"), new Country(258, "Mozambique"), new Country(256, "Uganda"));
		return countries;
	}

}
