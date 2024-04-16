package com.atlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atlas.model.User;
import com.atlas.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) throws Exception {
		
		User userTosave = userRepository.findByEmail(user.getEmail());
		if(userTosave!=null) {
			throw new Exception("user already exist with " + user.getEmail());
		}
		
		User savedUser =  userRepository.save(user);
		
		return savedUser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		
		userRepository.deleteById(userId);
		
		return "User deleted successfully";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() throws Exception{
		
		List<User> users = userRepository.findAll();
		
		return users;
	}

}
