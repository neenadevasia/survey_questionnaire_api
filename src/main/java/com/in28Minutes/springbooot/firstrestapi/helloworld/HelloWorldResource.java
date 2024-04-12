package com.in28Minutes.springbooot.firstrestapi.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {
	
	@RequestMapping("/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@RequestMapping("/hello-world-bean")
	public HelloWorlBean helloWorldBean() {
		return new HelloWorlBean("Hello World!");
	}
	
	@RequestMapping("/hello-world-path-param/{name}/message/{message}")
	public HelloWorlBean helloWorldMultiplePathParam(@PathVariable String name,@PathVariable String message) {
		return new HelloWorlBean("Hello World! "+name +","+message );
	}

}
