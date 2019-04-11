package com.klayrocha.jumia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.klayrocha.jumia.entity.Country;
import com.klayrocha.jumia.entity.Customer;

@Service
public interface CustomerService {

	Page<Customer> findAll(int page, int count);

	Page<Customer> findByCountry(int page, int count, String country, String state);

	List<Country> findCountries();
}
