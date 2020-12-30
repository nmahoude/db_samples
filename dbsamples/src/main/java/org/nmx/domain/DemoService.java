package org.nmx.domain;

import org.nmx.domain.services.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	private static final Logger log = LoggerFactory.getLogger(DemoService.class);

	@Autowired private CustomerRepository repository;
	@Autowired private JdbcTemplate jdbcTemplate;
	
	
	
	public void playWithJpa() {
    // save a few customers
		Address bauerAddress = new Address("street", "Atlanta", "xxxx");
		
    Customer jack = new Customer("Jack", "Bauer");
    jack.setAddress(bauerAddress);
    Customer chloe = new Customer("Chloe", "O'Brian");
    chloe.setAddress(bauerAddress);
		
    
    
    repository.save(jack);
		repository.save(chloe);
    repository.save(new Customer("Kim", "Bauer"));
    repository.save(new Customer("David", "Palmer"));
    repository.save(new Customer("Michelle", "Dessler"));

    // fetch using jdbcTemplate
    log.info("Getting back the column names");
    log.info("-------------------------------");
    jdbcTemplate.queryForObject("select * from customer where rownum=1", (rs, rowNum) -> {
    	for (int i=1;i<rs.getMetaData().getColumnCount();i++) {
    		log.warn(rs.getMetaData().getColumnName(i));
    	}
    	return null;
    });

    
    
    
    // fetch all customers
    log.info("Customers found with findAll():");
    log.info("-------------------------------");
    for (Customer customer : repository.findAll()) {
      log.info(customer.toString());
    }
    log.info("");

    // fetch an individual customer by ID
    Customer customer = repository.findById(1L);
    log.info("Customer found with findById(1L):");
    log.info("--------------------------------");
    log.info(customer.toString());
    log.info("");

    // fetch customers by last name
    log.info("Customer found with findByLastName('Bauer'):");
    log.info("--------------------------------------------");
    repository.findByLastName("Bauer").forEach(bauer -> {
      log.info(bauer.toString());
    });
    // for (Customer bauer : repository.findByLastName("Bauer")) {
    //  log.info(bauer.toString());
    // }
    log.info("");
	}

}
