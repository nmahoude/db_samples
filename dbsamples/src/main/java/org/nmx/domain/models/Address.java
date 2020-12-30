package org.nmx.domain.models;

import javax.persistence.Embeddable;

/**
 * simple VO to map in jpa
 * 
 * embeddable, so it is saved in the same db row
 * aka denormalisation
 * 
 * @author nmahoude
 *
 */
@Embeddable
public class Address {
	public final String street;
	public final String city;
	public final String postalCode;
	
	/** 
	  default constructor needed for persistence framework 
		even if fields are final, JPA can map them !? 
	**/
	@SuppressWarnings("unused")
	private Address() {
		this.street = "";
		this.city = "";
		this.postalCode = "";
	}
	
	public Address(String street, String city, String postalCode) {
		super();
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}
	
	@Override
		public String toString() {
			return String.format("%s-%s-%s (%s)", street, city, postalCode, super.toString());
		}
	
}
