package com.sleepingsloth.insuredme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleepingsloth.insuredme.dao.QuoteRequestRepository;
import com.sleepingsloth.insuredme.domain.QuoteRequest;
import com.sleepingsloth.insuredme.domain.UserType;

@Controller
@RequestMapping(path = "/quote")
public class QuoteRequestController {
	private static final Logger LOGGER = Logger.getLogger( QuoteRequestController.class.getName() );

	@Autowired
	private QuoteRequestRepository quoteRequestRepository;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewQuote(@RequestParam String email, 
			@RequestParam String password, 
			@RequestParam String name, 
			@RequestParam String surname, 
			@RequestParam String address,
			@RequestParam UserType type) {
		QuoteRequest n = new QuoteRequest();
		quoteRequestRepository.save(n);
		return "User '" + name + "' has been saved with id: " + n.getId();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<QuoteRequest> getAllQuotes() {
		return quoteRequestRepository.findAll();
	}
}
