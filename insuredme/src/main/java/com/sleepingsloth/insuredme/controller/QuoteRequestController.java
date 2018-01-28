package com.sleepingsloth.insuredme.controller;

import static java.lang.Long.valueOf;

import java.util.ArrayList;
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
import com.sleepingsloth.insuredme.domain.QuoteModel;
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
	public @ResponseBody QuoteRequest addNewQuote(@RequestBody Map<String, String> map) {
		Long userId;
		if(map.get("userId") == null){
			// If user not logged-in create user account (sneaky hehe)
			User user = new User();
			user.setEmail(map.get("email"));
			user.setName(map.get("name"));
			user.setAddress(map.get("address"));
			user.setPassword(map.get("password"));
			user.setSurname(map.get("surname"));
			user.setUserType(UserType.INDIVIDUAL);
			userRepository.save(user);
			userId = user.getId();
		} else {
			userId = Long.valueOf(map.get("userId"));
		}
		LOGGER.info("User " + userId + " created for quote");

		// Create quote request
		QuoteRequest quoteRequest = new QuoteRequest();
		quoteRequest.setInsuranceTypeCode(map.get("insuranceTypeCode"));
		quoteRequest.setUserId(userId);
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
		return quoteRequest;
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<QuoteRequest> getAllQuotes() {
		return quoteRequestRepository.findAll();
	}

	@GetMapping(path = "/find")
	public @ResponseBody Iterable<QuoteModel> getAllQuotesForUser(@RequestParam long userId) {
		Iterable<QuoteRequest> requests = quoteRequestRepository.findByUserIdOrderById(userId);
		 ArrayList<QuoteModel> models = new ArrayList<QuoteModel>();
		for(QuoteRequest request : requests){
			QuoteModel m = new QuoteModel();
			m.setQuoteRequest(request);
			m.setCarRegistrationNumber(answerRepository.findTopByQuoteRequestIdAndQuestionId(request.getId(), 1).getAnswer());
			models.add(m);
		}
		
		return models;
	}
}
