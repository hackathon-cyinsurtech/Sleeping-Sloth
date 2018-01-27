package com.sleepingsloth.insuredme.controller;

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
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String email, 
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
		return "User '" + name + "' has been saved with id: " + n.getId();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
