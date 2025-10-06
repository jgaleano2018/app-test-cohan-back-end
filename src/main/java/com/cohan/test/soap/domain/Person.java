package com.cohan.test.soap.domain;

public class Person {
	
	private String nif;
	private String name;
	private String phone;
	private String email;
	
	public Person() {
		super();
		this.nif = "";
		this.setName("");
		this.setPhone("");
		this.setEmail("");
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	

}