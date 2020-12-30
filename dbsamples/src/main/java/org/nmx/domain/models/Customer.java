package org.nmx.domain.models;

public class Customer {
  private Long id;
  private String firstName;
  private String lastName;

  private Address address;
  
  protected Customer() {}

  public Customer(String firstName, String lastName) {
  	this(null, firstName, lastName);
  }

  public Customer(Long id, String firstName, String lastName) {
  	this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
	}

	@Override
  public String toString() {
    return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s', adresse='%s']",
        id, firstName, lastName, address);
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}
}
