package com.cohan.test.domain.model;

import java.util.UUID;

public class Address {
	private UUID idAddress; // matches id_colaborador INT
	private Integer street;
	private String city;
	private String state;
	private String postalCode;
	private String country;
		
	// constructors, getters, setters
	
	
	public Address() {}
	
	
	public Address(UUID idAddress, Integer street, String city, String state, String postalCode, String country) {
		this.idAddress = idAddress;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}


	public UUID getIdAddress() {
		return idAddress;
	}


	public void setIdAddress(UUID idAddress) {
		this.idAddress = idAddress;
	}


	public Integer getStreet() {
		return street;
	}


	public void setStreet(Integer street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	
	
	
}