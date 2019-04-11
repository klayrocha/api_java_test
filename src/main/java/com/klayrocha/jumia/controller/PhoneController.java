package com.klayrocha.jumia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klayrocha.jumia.entity.Country;
import com.klayrocha.jumia.entity.Customer;
import com.klayrocha.jumia.response.Response;
import com.klayrocha.jumia.service.CustomerService;

/**
 * Class RESTful for PhoneController
 * 
 * @author Francis Klay Rocha
 *
 */

@RestController
@RequestMapping("/api/phone")
@CrossOrigin(origins = "*")
public class PhoneController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "{page}/{count}")
	public ResponseEntity<Response<Page<Customer>>> findAll(@PathVariable int page, @PathVariable int count) {
		Response<Page<Customer>> response = new Response<Page<Customer>>();
		Page<Customer> customers = customerService.findAll(page, count);
		response.setData(customers);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{page}/{count}/{countryCode}/{state}")
	public ResponseEntity<Response<Page<Customer>>> findByCountryState(@PathVariable int page, @PathVariable int count,
			@PathVariable String countryCode, @PathVariable String state) {
		Response<Page<Customer>> response = new Response<Page<Customer>>();
		Page<Customer> customers = customerService.findByCountryState(page, count, countryCode, state);
		response.setData(customers);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/countries")
	public ResponseEntity<Response<List<Country>>> findCountries() {
		Response<List<Country>> response = new Response<List<Country>>();
		List<Country> countries = customerService.findCountries();
		response.setData(countries);
		return ResponseEntity.ok(response);
	}

}
