package org.nmx.infrastructure.adapters.persistance.customers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.nmx.domain.models.Address;
import org.nmx.domain.models.Customer;

@Entity
@Table(name = "Customer")
class CustomerJPA {
	@Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;

	public String street;
	public String city;
	public String postalCode;
  
	Customer map() {
		Customer customer = new Customer(this.id, this.firstName, this.lastName);
		customer.setAddress(new Address(street, city, postalCode));
		return customer;
	}
	
	static CustomerJPA from(Customer customer) {
		CustomerJPA c = new CustomerJPA();
		c.id = customer.getId();
		c.firstName = customer.getFirstName();
		c.lastName = customer.getLastName();
		if (customer.getAddress() != null) {
			c.street =  customer.getAddress().street;
			c.city=  customer.getAddress().city;
			c.postalCode =  customer.getAddress().postalCode;
		}
		return c;
	}
	
}
