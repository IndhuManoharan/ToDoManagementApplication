package com.todoApplication.rest.webservices.rest.basic.authentication;

public class HttpBasicAuthBean {

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

	public HttpBasicAuthBean(String message) {
		this.message = message;
	}

}
