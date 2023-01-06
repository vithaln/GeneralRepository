package com.vithal.code.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;
import com.vithal.code.DepartemntServiceConfig;
import com.vithal.code.entity.Department;
import com.vithal.code.entity.User;
import com.vithal.code.exceptions.UserNotFoundException;
import com.vithal.code.repository.UserRepo;
import com.vithal.code.service.UserServcie;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserServcie{

	@Value("${department.base.value}")
	private String DEPRT_BASE_URL;
	
	
	@Autowired
	private DepartemntServiceConfig config;
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public User createUser(User user) {
		
		String uid = UUID.randomUUID().toString();
		user.setUId(uid);
		User userSaved = repo.save(user);
		return userSaved;
	}

	@Override
	public List<User> getAllusers() {
	List<User> users = repo.findAll();
		return users;
	}

	@Override
	public User getSingleUser(String uId) {
		User user = repo.findById(uId).orElseThrow(()->new UserNotFoundException("User Not Found by using this Id-->"+uId));
		
		log.info("USER==> {} ",user);
		
		//calling other service
		 ArrayList deprts = restTemplate.getForObject(DEPRT_BASE_URL+user.getUId(), ArrayList.class);
		user.setDeprts(deprts);
		
		// Department departmentsBydepartlId = config.getDepartmentsBydepartlId("DEPRT_BASE_URL"+user.getUId());
		
	//	user.setDeprts(departmentsBydepartlId);
		
		log.info("Departments==>> {} ",user);
		
		
		return user;
	}

	@Override
	public User updateUsers(User user, String uId) {
		User usr = repo.findById(uId).orElseThrow(()->new UserNotFoundException("User Not Found by using this Id-->"+uId));

		usr.setFirstName(user.getFirstName());
		usr.setLastName(user.getLastName());
		usr.setCity(user.getCity());
		usr.setCountry(user.getCountry());
		usr.setEmail(user.getEmail());
		//usr.setUId(user.getUId()); never do it
		User updatedUser = repo.save(usr);
		return updatedUser;
	}

	@Override
	public String deleteUser(String uId) {
		repo.findById(uId).orElseThrow(()->new UserNotFoundException("User Not Found by using this Id-->"+uId));

				repo.deleteById(uId);
		return "User has been deleted successfully!!";
	}

}
