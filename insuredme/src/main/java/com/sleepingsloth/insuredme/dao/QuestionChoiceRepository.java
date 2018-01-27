package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sleepingsloth.insuredme.domain.QuestionChoice;

public interface QuestionChoiceRepository extends CrudRepository<QuestionChoice, Long> {
	
	public Iterable<QuestionChoice> findByQuestionId(@Param("questionId") long questionId);
}
