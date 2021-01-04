package com.todoApplication.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {

//	@RequestMapping(method = RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String printHelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean printHelloWorldBean() {
//		throw new RuntimeException("Some error occured");
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}/{no}")
	public HelloWorldBean printHelloWorldPathVariable(@PathVariable String  name,@PathVariable int  no) {
		return new HelloWorldBean(String.format("Hello World , %s ,%d", name,no));
	}
}
