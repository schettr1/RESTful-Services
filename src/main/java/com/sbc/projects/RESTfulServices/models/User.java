package com.sbc.projects.RESTfulServices.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue
	@NotNull(message="ID must not be null")
	private int id;
	
	@Size(min=2, message="Name must have at least 2 characters")
	private String name;
	
	@Past(message="DOB must be in Past.")
	private Date DoB;
	
	
	public User() {
	}
	
	public User(int id, String name, Date doB) {

		this.id = id;
		this.name = name;
		DoB = doB;
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
	public Date getDoB() {
		return DoB;
	}
	public void setDoB(Date doB) {
		DoB = doB;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", DoB=" + DoB + "] \n";
	}
	
	
	
}
