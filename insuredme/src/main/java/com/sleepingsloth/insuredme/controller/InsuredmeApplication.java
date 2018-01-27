	package com.sleepingsloth.insuredme.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sleepingsloth.insuredme.domain.User;

@RestController
@EnableAutoConfiguration
public class InsuredmeApplication {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	 private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping("/greeting")
	    public User greeting(@RequestParam(value="name", defaultValue="World") String name) {
	        return new User();
	    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(InsuredmeApplication.class, args);
	}

}