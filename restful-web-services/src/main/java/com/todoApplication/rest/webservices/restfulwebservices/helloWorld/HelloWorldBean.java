package com.todoApplication.rest.webservices.restfulwebservices.helloWorld;

public class HelloWorldBean {

	String message;
	
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message) {
		this.message = message;
	}

}
