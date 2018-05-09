package com.sbc.projects.RESTfulServices.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbc.projects.RESTfulServices.dao.UserDao;
import com.sbc.projects.RESTfulServices.exceptions.DeleteUserException;
import com.sbc.projects.RESTfulServices.exceptions.UserNotFoundException;
import com.sbc.projects.RESTfulServices.models.User;

@RestController
public class MainController {

	@Autowired
	private UserDao userdao;
	
	// Returns list of all users
	@GetMapping(value="/users")
	public List<User> getAllUsers(){
		return userdao.getAllUsers();
	}
	
	
	// Return messege: ID NOT_FOUND, error: NOT FOUND and status: 404 whenever there is no requested ID found in DB
	@GetMapping(value="/users/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUserById(@PathVariable int id){
		User user = userdao.getUserById(id);
		if(user == null){
				throw new UserNotFoundException("GET_ID " + id + " NOT_FOUND");
		}
		return user;		
	}
	
	
	// Return messege: ID NOT_FOUND, error: NOT FOUND and status: 404 whenever there is no requested ID found in DB
	@DeleteMapping(value="/users/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable int id){
		boolean isDeleted = false;
		isDeleted = userdao.deleteUserById(id);
		if(isDeleted == false){
				throw new DeleteUserException("DELETE_ID " + id + " NOT_FOUND");
		}
		return ResponseEntity.noContent().build();		// returns status: '204 No Content' when deleted successfully. One can simply return null as well.
	}
	
	
	@PutMapping(value="/users")
	public boolean updateUser(@RequestBody User user){
		return userdao.updateUser(user);
	}
	
/*	// COMMENT OUT THIS SECTION - use HATEOAS Implementation instead
	// Return response to client as a STATUS CODE and also URI location of the created object 
	// instead of returning a boolean or created object
	@PostMapping(value="/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
		
		User newUser = userdao.addUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();	// returns status: '201 Created' and Header Message: path URI of the added user 
	}*/
	
	//*****************************************  HATEOAS IMPLEMENTION  ***************************************************************
	// import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
	// else methodOn() will give an error.
	// Also add 'org.springframework.hateoas' dependency
	// NOTE: URI location is not used while using HATEOAS?? this is because if you are using 
	// HATEOAS you are sending link in the message and not in the header of response
	
	
	@PostMapping(value="/users")
	public Resource<User> addUser(@Valid @RequestBody User user){		
		// @Valid puts constraint in the request parameter; CustomExceptionHandler is used to respond if those constraint are breached
		
		User newUser = userdao.addUser(user);

		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo( methodOn(this.getClass()).getUserById(user.getId()) );
		resource.add(linkTo.withRel("USER_LINK"));
		return resource;
	}

}




///////////////////////////// CRUD OPERATION WITHOUT RESPONSE_STATUS OR HATEOAS /////////////////////////////////// 


/*
 * 	// Return messege: ID NOT_FOUND, error: NOT FOUND and status: 404 whenever there is no requested ID found in DB
	@GetMapping(value="/users/{id}")
	public User getUserById(@PathVariable int id){
		User user = userdao.getUserById(id);
		if(user == null){
				throw new UserNotFoundException("GET_ID " + id + " NOT_FOUND");
		}
		return user;		
	}
	
	
	// Return messege: ID NOT_FOUND, error: NOT FOUND and status: 404 whenever there is no requested ID found in DB
	@DeleteMapping(value="/users/{id}")
	public boolean deleteUserById(@PathVariable int id){
		boolean isDeleted = false;
		isDeleted = userdao.deleteUserById(id);
		if(isDeleted == false){
				throw new DeleteUserException("DELETE_ID " + id + " NOT_FOUND");
		}
		return isDeleted;
	}
	
	
	// Return response to client as a STATUS CODE and also URI location of the created object 
	// instead of returning a boolean or created object
	@PostMapping(value="/users")
	public User addUser(@RequestBody User user){
		User newUser = userdao.addUser(user);
		return newUser;		 
	}
	
	
	@PutMapping(value="/users")
	public boolean updateUser(@RequestBody User user){
		return userdao.updateUser(user);
	}
	
	*/
