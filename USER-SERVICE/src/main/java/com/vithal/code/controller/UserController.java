package com.vithal.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vithal.code.entity.User;
import com.vithal.code.service.UserServcie;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServcie servcie;
	
	@PostMapping("/")
	public ResponseEntity<User>createUsers(@RequestBody User usr){
		User createUser = servcie.createUser(usr);
		
		return new ResponseEntity(createUser,HttpStatus.CREATED);
		
	}
	@GetMapping("/")
	public ResponseEntity<List<User>>getAllusers(){
		
		List<User> allusers = servcie.getAllusers();
		
		return new ResponseEntity<List<User>>(allusers,HttpStatus.OK);
	}
	//get users by userId
	@GetMapping("/{uid}")
	public ResponseEntity<User>getSingleUser(@PathVariable String uid){
		
		User singleUser = servcie.getSingleUser(uid);
		
		return new ResponseEntity<User>(singleUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/{uid}")
	public ResponseEntity<String>deleteUser(@PathVariable String uid){
		
		servcie.deleteUser(uid);
		
		return  ResponseEntity.ok("User has been deleted");
	}
	
	@PutMapping("/{uid}")
	public ResponseEntity<User> updateusers(@RequestBody User user,@PathVariable String uid) {
		User updateUsers = servcie.updateUsers(user, uid);
		
		return new ResponseEntity<User>(updateUsers,HttpStatus.OK);
	}
}
