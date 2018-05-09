package com.sbc.projects.RESTfulServices.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sbc.projects.RESTfulServices.models.User;


@Component
public class UserDao {

	List<User> users = new ArrayList<>();
	
	// Generate list of users in Empty Constructor
	public UserDao(){
		User user1 = new User(1, "Surya", new Date());
		User user2 = new User(2, "Bikram", new Date());
		User user3 = new User(3, "Gautam", new Date());
		User user4 = new User(4, "Chettri", new Date());
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}

	
	// GET ALL USERS
	public List<User> getAllUsers(){
		return users;
	}
	
	// GET USER BY ID
	public User getUserById(int id){
		for(User user: users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	// DELETE USER BY ID
	public boolean deleteUserById(int id){
		// Using boolean isDeleted = false; gives random status 500 error. So avoid using boolean.
		User user = null;
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()){
			user = itr.next();
			if(user.getId() == id){
				users.remove(user); 
				return true;
			}
		}
		return false;
	}
	
	//ADD USER TO LIST 
	public User addUser(User newUser){
		
		users.add(newUser);
		return newUser;
		
	}
	
	// UPDATE USER BY COMPARING IDs
	public boolean updateUser(User newUser){
		// Using boolean isUpdated = false; gives random status 500 error. So avoid using boolean.
		User oldUser = null;
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()){
			oldUser = itr.next();
			if(oldUser.getId() == newUser.getId()){
				users.remove(oldUser);
				users.add(newUser);
				return true;
			}
		}
		return false;
		
	}

	
	
	
}
