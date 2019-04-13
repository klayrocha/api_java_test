package com.klayrocha.jumia.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klayrocha.jumia.entity.Country;
import com.klayrocha.jumia.entity.Customer;
import com.klayrocha.jumia.repository.CustomerRepository;

/**
 * Service class for query in database and business rules
 * 
 * @author Francis Klay Rocha
 *
 */
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
	public Page<Customer> findByCountryState(int page, int count, String countryCode, String state) {
		Page<Customer> customers;

		// On the front-end, when you do not enter country or state, it is populated
		// with the word uninformed
		countryCode = countryCode.equals("uninformed") ? "" : countryCode;
		state = state.equals("uninformed") ? "" : state;

		// This code was necessary because the state is not in the database, so to
		// filter by state, it needs to return all records
		if (!"".equals(state)) {
			count = 41;
		}

		Pageable pages = PageRequest.of(page, count);

		if (!"".equals(countryCode)) {
			customers = this.customerRepository.findByCountry(pages, countryCode);
		} else {
			customers = this.customerRepository.findAllOrderByCountry(pages);
		}

		if (!"".equals(state)) {
			String stateFilter = state;
			List<Customer> customersFiltered = customers.stream().filter(c -> c.getState().equals(stateFilter))
					.collect(Collectors.toList());
			customers = new PageImpl<>(customersFiltered, pages, customersFiltered.size());
		}

		return customers;
	}

	@Override
	public List<Country> findCountries() {
		List<Country> countries = Arrays.asList(new Country(237, "Cameroon"), new Country(251, "Ethiopia"),
				new Country(212, "Morocco"), new Country(258, "Mozambique"), new Country(256, "Uganda"));
		return countries;
	}

	@Override
	public Object[] findChart() {
		return this.customerRepository.findChart();
	}

}
