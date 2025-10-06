package com.cohan.test.soap.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.cohan.test.soap.domain.Person;

@Component
public class PersonRepository {
	
	private static final Map<String, Person> persons = new HashMap<>();

	@PostConstruct
	public void initData() {
		Person a = new Person();
		a.setNif("1000000A");
		a.setName("prueba1");
		a.setPhone("310100000");
		a.setEmail("prueba1@gmail.com");
		
		Person b = new Person();
		b.setNif("2000000A");
		b.setName("prueba2");
		b.setPhone("310100001");
		b.setEmail("prueba2@gmail.com");

		persons.put(a.getNif(), a);
		persons.put(b.getNif(), b);
		
	}

	public Person findPerson(String nif) {		
		return persons.get(nif);
	}
	
	
}