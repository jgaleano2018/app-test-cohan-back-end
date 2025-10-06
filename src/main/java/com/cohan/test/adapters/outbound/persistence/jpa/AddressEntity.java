package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_address", updatable = false, nullable = false)
    private UUID idAddress;
    private Integer street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    
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

    // constructors, getters, setters
}
