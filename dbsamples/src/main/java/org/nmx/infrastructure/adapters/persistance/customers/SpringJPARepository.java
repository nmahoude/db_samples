package org.nmx.infrastructure.adapters.persistance.customers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

interface SpringJPARepository extends CrudRepository<CustomerJPA, Long> {
	 List<CustomerJPA> findByLastName(String lastName);

	  CustomerJPA findById(long id);
	  
}
