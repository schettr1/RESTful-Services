package com.sbc.projects.RESTfulServices.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter(value="EmployeeFilter")
public class Employee {

/**
 * This class is created to use with class: 'FilteringController.java' 
 * from package: 'com.sbc.projects.RESTfulServices.controller'
 * @Test the filter properties of spring-boot 
 * Send response with only selected attributes from the class Employee
 * 
 */
	private int id;
	
	private String name;
	
	private String position;
	
	@JsonIgnore
	private int ssn;

	public Employee() {

	}

	public Employee(int id, String name, String position, int ssn) {

		this.id = id;
		this.name = name;
		this.position = position;
		this.ssn = ssn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	
}
