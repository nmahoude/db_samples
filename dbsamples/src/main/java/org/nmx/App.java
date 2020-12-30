package org.nmx;


import org.hibernate.service.spi.InjectService;
import org.nmx.domain.Customer;
import org.nmx.domain.DemoService;
import org.nmx.infrastructure.JPACustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	@Autowired DemoService demo;
	

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


  @Bean
  public CommandLineRunner demo() {
    return (args) -> {
    	demo.playWithJpa();
    };
  }
}
