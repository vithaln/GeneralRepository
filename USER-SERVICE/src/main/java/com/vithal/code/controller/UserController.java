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

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserServcie servcie;
	
	int retryCount=1;
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
	//@CircuitBreaker(name = "usrDepart", fallbackMethod = "DepartmentFallbackMethod")
	//@Retry(name = "userDepartmet", fallbackMethod = "DepartmentFallbackMethod")
	@RateLimiter(name = "userDepart", fallbackMethod = "DepartmentFallbackMethod")
	public ResponseEntity<User>getSingleUser(@PathVariable String uid){
		
		log.info("USER CONTROLLER CALLLED !!");
		log.info("retryCount called {} ",retryCount);
		retryCount++;
		
		User singleUser = servcie.getSingleUser(uid);
		
		return new ResponseEntity<User>(singleUser,HttpStatus.OK);
	}
	
	
	//fallback method
	public ResponseEntity<User>DepartmentFallbackMethod( String uid, Exception ex) {
		
		log.info("FALLBACK IS CALLED DUE TO SOME OTHER SERVICES ARE DOWN PLEASE TRY LATER!, {} ",ex.getMessage());
	
	
		User usr = User.builder().uId("456")
		.firstName("dummy").lastName("dummyDta").city("dummyyyyyyy").country("Invalid country dummy datat").email("dummy@gmail.com")
		.build();
		
		return ResponseEntity.ok(usr);
		
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
