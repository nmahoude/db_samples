package org.nmx.application;


import org.nmx.domain.boundary.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
// Lot of annotations to add because App is not at the root of project
@ComponentScan(basePackages = {"org.nmx"})
@EnableJpaRepositories("org.nmx")
@EntityScan("org.nmx")
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
