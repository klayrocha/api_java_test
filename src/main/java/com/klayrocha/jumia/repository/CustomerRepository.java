package com.klayrocha.jumia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klayrocha.jumia.entity.Customer;

/**
 * Repository interface for searching the database
 * 
 * @author Francis Klay Rocha
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "SELECT c FROM Customer c WHERE substr(c.phone,2,3) = :countryCode")
	Page<Customer> findByCountry(Pageable pages, @Param("countryCode") String countryCode);

	@Query(value = "SELECT c FROM Customer c order by substr(c.phone,2,3)")
	Page<Customer> findAllOrderByCountry(Pageable pages);
}
