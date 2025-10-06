package com.cohan.test.soap.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.cohan.test.soap.domain.Person;
import com.cohan.test.soap.repository.PersonRepository;
import com.cohan.test.web_service_soap.PersonInfo;
import com.cohan.test.web_service_soap.GetPersonRequest;
import com.cohan.test.web_service_soap.GetPersonResponse;


@Endpoint
public class PersonEndpoint {
	private static final String NAMESPACE_URI = "http://cohan.test.com/web-service-soap";

	@Autowired
	private PersonRepository personRepository;
		
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
	@ResponsePayload
	public GetPersonResponse getPerson(@RequestPayload GetPersonRequest request) {
		GetPersonResponse response = new GetPersonResponse();
		
		Person p = personRepository.findPerson(request.getNif());
		PersonInfo person = new PersonInfo();
		person.setNif(p.getNif());
		person.setName(p.getName());		
		person.setPhone(p.getPhone());
		person.setEmail(p.getEmail());
		
		response.setPersonInfo(person);
		return response;
	}
	
	
	
	
}