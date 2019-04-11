package com.klayrocha.jumia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.klayrocha.jumia.entity.Country;
import com.klayrocha.jumia.entity.Customer;

/**
 * Service interface for query in database and business rules
 * 
 * @author Francis Klay Rocha
 *
 */
@Service
public interface CustomerService {

	Page<Customer> findAll(int page, int count);

	Page<Customer> findByCountryState(int page, int count, String country, String state);

	List<Country> findCountries();
}
