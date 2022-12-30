package com.vithal.code.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vithal.code.entity.User;
import com.vithal.code.exceptions.UserNotFoundException;
import com.vithal.code.repository.UserRepo;
import com.vithal.code.service.UserServcie;

@Service
public class UserServiceImpl implements UserServcie{

	@Autowired
	private UserRepo repo;
	
	
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
