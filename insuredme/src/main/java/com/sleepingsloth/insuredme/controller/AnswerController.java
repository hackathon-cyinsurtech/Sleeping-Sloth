package com.sleepingsloth.insuredme.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sleepingsloth.insuredme.dao.AnswerRepository;
import com.sleepingsloth.insuredme.domain.Answer;

import javassist.bytecode.stackmap.TypeData.ClassName;

@Controller
@RequestMapping(path="/answer")
public class AnswerController {
	
	private static final Logger LOGGER = Logger.getLogger( AnswerController.class.getName() );
	
	@Autowired
	private AnswerRepository answerRepository;

	@PostMapping(path="/add")
	public @ResponseBody Long addAnswer (@RequestBody Answer answer) {
		answerRepository.save(answer);
		LOGGER.info("Answer has been saved with id: " + answer.getId());
		return answer.getId();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Answer> getAllAnswer() {
		LOGGER.info("Selecting all answers");
		return answerRepository.findAll();
	}
}
