package com.sbc.projects.RESTfulServices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sbc.projects.RESTfulServices.models.Employee;


// @JsonIgnore
// private int ssn;
// can be used to ignore the ssn data in response. However, we will exclude the data dynamically rather than statically.

@RestController
public class FilteringController {

/**
 * This Controller Class is created to use with class: 'Employee.java' 
 * from package: 'com.sbc.projects.models'
 * @Test the filter properties of spring-boot 
 * Send response with only selected attributes from the class Employee
 * 
 */
	
	@GetMapping(value="/employees")
	public MappingJacksonValue getAllEmployees(){

		List<Employee> employees = Arrays.asList(new Employee(1, "Ram", "Cashier", 12345), 
				new Employee(2, "Sham", "Cashier", 23456),
				new Employee(3, "Mohan", "Cashier", 34567));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(employees);
		mapping.setFilters(filters);
		return mapping;	
	}
	
	@GetMapping(value="/employees/{id}")
	public MappingJacksonValue getEmployeeById(@PathVariable int id){

		Employee employeeFound = null;
		List<Employee> employees = Arrays.asList(new Employee(1, "Ram", "Cashier", 12345), 
				new Employee(2, "Sham", "Cashier", 23456),
				new Employee(3, "Mohan", "Manager", 34567));
		
		for(Employee employee: employees){
			if(employee.getId() == id){
				employeeFound = employee;
			}
		}	

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "position");
		FilterProvider filters = new SimpleFilterProvider().addFilter("EmployeeFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(employeeFound);
		mapping.setFilters(filters);
		return mapping;	
		
	}
}
