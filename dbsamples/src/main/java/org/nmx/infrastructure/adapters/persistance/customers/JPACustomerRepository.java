package org.nmx.infrastructure.adapters.persistance.customers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.nmx.domain.models.Customer;
import org.nmx.domain.services.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPACustomerRepository implements  CustomerRepository {
	@Autowired SpringJPARepository jpaRepository;
	
  public List<Customer> findByLastName(String lastName) {
  	List<CustomerJPA> customers = jpaRepository.findByLastName(lastName);
  	return customers.stream().map(CustomerJPA::map).collect(Collectors.toList());
  }

  public Customer findById(long id) {
  	return jpaRepository.findById(id).map();
  }

	@Override
	public void save(Customer customer) {
		jpaRepository.save(CustomerJPA.from(customer));
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> list = new ArrayList<>();
		jpaRepository.findAll().forEach(c -> list.add(c.map()));
		return list;
	}
}
