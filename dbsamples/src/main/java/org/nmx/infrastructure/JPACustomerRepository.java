package org.nmx.infrastructure;

import java.util.List;

import org.nmx.domain.Customer;
import org.nmx.domain.services.CustomerRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface JPACustomerRepository   extends  CustomerRepository, CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}
