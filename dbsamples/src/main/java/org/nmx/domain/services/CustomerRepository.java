package org.nmx.domain.services;

import java.util.List;

import org.nmx.domain.Customer;

public interface CustomerRepository {
	  List<Customer> findByLastName(String lastName);

	  Customer findById(long id);

		void save(Customer customer);

		List<Customer> findAll();
}
