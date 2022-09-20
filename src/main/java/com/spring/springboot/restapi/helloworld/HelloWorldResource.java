package com.spring.springboot.restapi.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {
	
	
	@RequestMapping("/hello-world")
	public String helloworld() {
		
		return "hello world";
		
	}
	
	@RequestMapping("/hello-world-bean")
	public  HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("helloworld-bean");
		
	}
	
	@RequestMapping("/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanPath(@PathVariable String name) {
		
		return new HelloWorldBean("welcome  " + name );
		
	}
	

}
