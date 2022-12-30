package com.vithal.code.service;

import java.util.List;

import com.vithal.code.entity.User;

public interface UserServcie {

	//create users
	
	User createUser(User user);
	
	//get all users
	
	List<User> getAllusers();
	
	//get single user
	
	User getSingleUser(String uId);
	
	//upudate users
	
	User updateUsers(User user,String uId);
	
	//delete users
	
	String deleteUser(String uId);
}
