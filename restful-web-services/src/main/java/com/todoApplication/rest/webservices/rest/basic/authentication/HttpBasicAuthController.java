package com.todoApplication.rest.webservices.rest.basic.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HttpBasicAuthController {

	
	@GetMapping(path="/basicAuth")
	public HttpBasicAuthBean printHelloWorldBean() {
//		throw new RuntimeException("Some error occured");
		return new HttpBasicAuthBean("You are authenticated");
	}
	
}
