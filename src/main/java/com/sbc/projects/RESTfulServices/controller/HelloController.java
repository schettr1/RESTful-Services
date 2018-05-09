package com.sbc.projects.RESTfulServices.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbc.projects.RESTfulServices.service.additional.JsonData;

@RestController
public class HelloController {

	
	@RequestMapping(method = RequestMethod.GET, value="/a")
	public String HelloWorld1(){
		return "Hello A!";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/b")
	public JsonData HelloWorld2(){
		return new JsonData(String.format("Hello B"));
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{name}")
	public JsonData HelloWorld3(@PathVariable String name){
		return new JsonData(String.format("Your name is %s", name));
		
	}
	
	
}
