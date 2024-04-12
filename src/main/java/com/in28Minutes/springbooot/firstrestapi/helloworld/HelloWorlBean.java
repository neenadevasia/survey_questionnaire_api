package com.in28Minutes.springbooot.firstrestapi.helloworld;

public class HelloWorlBean {
	
	
	public HelloWorlBean(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "HelloWorlBean [message=" + message + "]";
	}
	
	

}
