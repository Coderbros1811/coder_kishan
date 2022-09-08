package com.spring.boot.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.demo.model.UserData;
import com.spring.boot.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public List<UserData> returnHome() {
	
		List<UserData> users = new ArrayList<UserData>();  
		userRepository.findAll().forEach(user -> users.add(user));  
		log.info(""+userRepository.findAll());
		log.info("List "+users);
		return users;
	}
	
	@GetMapping("/{username}/{id}")
	public UserData addUser(@PathVariable String username, @PathVariable int id) {
		UserData u = new UserData();
		u.setId(id);
		u.setUsername(username);
		UserData user= userRepository.save(u);
		log.info(""+user);
		
		return user;
	}
	
	@GetMapping("/get")
	public Optional<UserData> getUser(@RequestParam int id) {
		
		log.info("ID:  {} "+id);
		@SuppressWarnings("removal")
		Optional<UserData> users= userRepository.findById(new Long(id));
		log.info(""+users);		
		return users;
	}
	
}
