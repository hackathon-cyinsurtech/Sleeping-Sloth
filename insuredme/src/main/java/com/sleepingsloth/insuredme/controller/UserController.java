package com.sleepingsloth.insuredme.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleepingsloth.insuredme.dao.UserRepository;
import com.sleepingsloth.insuredme.domain.User;
import com.sleepingsloth.insuredme.domain.UserType;

@Controller
@RequestMapping(path="/user")
public class UserController {
	private static final Logger LOGGER = Logger.getLogger( UserController.class.getName() );

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path="/add")
	public @ResponseBody Long addNewUser (@RequestParam String email, 
			@RequestParam String password,
			@RequestParam String name,
			@RequestParam String surname,
			@RequestParam String address,
			@RequestParam UserType type) {
		User n = new User();
		n.setEmail(email);
		n.setPassword(password);
		n.setName(name);
		n.setSurname(surname);
		n.setAddress(address);
		n.setUserType(type);
		userRepository.save(n);
		LOGGER.info("User '" + name + "' has been saved with id: " + n.getId());
		return n.getId();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/load")
	public @ResponseBody User getUser(@RequestParam String email, @RequestParam String password) {
		List<User> items = userRepository.loadUser(email, password);
		if (items.isEmpty()){
			return null;
		} else {
			return items.get(0);
		}
	}
	
	
	@GetMapping(path = "/loadUser")
	public @ResponseBody User getUser(@RequestParam String email) {
		return userRepository.findTopByEmail(email);
	}
}
