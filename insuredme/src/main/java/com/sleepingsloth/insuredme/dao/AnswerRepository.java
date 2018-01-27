package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;

import com.sleepingsloth.insuredme.domain.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	
}
