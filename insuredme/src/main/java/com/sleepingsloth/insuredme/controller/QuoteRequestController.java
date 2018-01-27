package com.sleepingsloth.insuredme.controller;

import static java.lang.Long.valueOf;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.sleepingsloth.insuredme.dao.AnswerRepository;
import com.sleepingsloth.insuredme.dao.QuoteRequestRepository;
import com.sleepingsloth.insuredme.dao.UserRepository;
import com.sleepingsloth.insuredme.domain.Answer;
import com.sleepingsloth.insuredme.domain.QuoteRequest;
import com.sleepingsloth.insuredme.domain.User;
import com.sleepingsloth.insuredme.domain.UserType;

@Controller
@RequestMapping(path = "/quote")
public class QuoteRequestController {
	private static final Logger LOGGER = Logger.getLogger(QuoteRequestController.class.getName());

	@Autowired
	private QuoteRequestRepository quoteRequestRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@PostMapping(path = "/add")
	public @ResponseBody Long addNewQuote(@RequestBody Map<String, String> map) {
		// Create user account (sneaky hehe)
		User user = new User();
		user.setEmail(map.get("email"));
		user.setName(map.get("name"));
		user.setAddress(map.get("address"));
		user.setPassword(map.get("password"));
		user.setSurname(map.get("surname"));
		user.setUserType(UserType.INDIVIDUAL);
		userRepository.save(user);
		LOGGER.info("User " + user.getId() + " created for quote");

		// Create quote request
		QuoteRequest quoteRequest = new QuoteRequest();
		quoteRequest.setInsuranceTypeCode(map.get("insuranceTypeCode"));
		quoteRequest.setUserId(user.getId());
		quoteRequestRepository.save(quoteRequest);
		LOGGER.info("Quote " + quoteRequest.getId() + " created");

		// Create answers
		for (String key : map.keySet()) {
			if (StringUtils.isStrictlyNumeric(key)) {
				if (map.get(key) != null && !map.get(key).isEmpty()) {
					Answer answer = new Answer();
					answer.setQuestionId(valueOf(key));
					answer.setAnswer(map.get(key));
					answer.setQuoteRequestId(quoteRequest.getId());
					answerRepository.save(answer);
					LOGGER.info("Answer  " + answer.getId() + " for quote : " + quoteRequest.getId());
				}
			}
		}
		LOGGER.info("Quote saving completed");
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
