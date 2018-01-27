package com.sleepingsloth.insuredme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleepingsloth.insuredme.dao.QuoteRequestRepository;
import com.sleepingsloth.insuredme.domain.QuoteRequest;

@Controller
@RequestMapping(path = "/quote")
public class QuoteRequestController {
	private static final Logger LOGGER = Logger.getLogger( QuoteRequestController.class.getName() );

	@Autowired
	private QuoteRequestRepository quoteRequestRepository;

	@PostMapping(path = "/add")
	public @ResponseBody Long addNewQuote(@RequestBody QuoteRequest quoteRequest) {
		quoteRequestRepository.save(quoteRequest);
		LOGGER.info("Quote saved");
		return quoteRequest.getId();
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<QuoteRequest> getAllQuotes() {
		return quoteRequestRepository.findAll();
	}
	
	
	@GetMapping(path = "/find")
	public @ResponseBody Iterable<QuoteRequest> getAllQuotesForUser(@RequestParam long userId) {
		return quoteRequestRepository.findByUserIdOrderById(userId);
	}
}
