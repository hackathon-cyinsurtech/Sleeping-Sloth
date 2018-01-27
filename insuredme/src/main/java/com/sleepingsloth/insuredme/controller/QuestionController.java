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

import com.sleepingsloth.insuredme.dao.QuestionChoiceRepository;
import com.sleepingsloth.insuredme.dao.QuestionRepository;
import com.sleepingsloth.insuredme.domain.Question;
import com.sleepingsloth.insuredme.domain.QuestionChoice;

@Controller
@RequestMapping(path="/question")
public class QuestionController {
	
	private static final Logger LOGGER = Logger.getLogger( QuestionController.class.getName() );
	
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private QuestionChoiceRepository questionChoiceRepository;

	@PostMapping(path="/add")
	public @ResponseBody Long addQuestion (@RequestBody Question question) {
		questionRepository.save(question);
		LOGGER.info("Question '" + question.getQuestion() + "' has been saved with id: " + question.getId());
		return question.getId();
	}
	
	
	@PostMapping(path="/addChoice")
	public @ResponseBody Long addQuestionChoice(@RequestBody QuestionChoice choice) {
		questionChoiceRepository.save(choice);
		LOGGER.info("Question choice'" + choice.getChoice() + "' for question with id: " + choice.getQuestionId());
		return choice.getId();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Question> getAllQuestion() {
		LOGGER.info("Selecting all questions");
		return questionRepository.findAll();
	}
	
	
	@GetMapping(path="/find")
	public @ResponseBody Iterable<Question> getAllQuestionForType(@RequestParam String insuranceTypeCode) {
		LOGGER.info("Selecting questions for type: " + insuranceTypeCode);
		return questionRepository.findByInsuranceTypeCodeOrderById(insuranceTypeCode);
	}
	
	
	@GetMapping(path="/choices")
	public @ResponseBody Iterable<QuestionChoice> getAllChoicesForQuestion(@RequestParam long questionId) {
		LOGGER.info("Selecting choices for question with id: " + questionId);
		return questionChoiceRepository.findByQuestionIdOrderById(questionId);
	}
	
	
	@GetMapping(path="/allchoices")
	public @ResponseBody Iterable<QuestionChoice> getAllChoices() {
		return questionChoiceRepository.findAll();
	}
}
