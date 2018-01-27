package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sleepingsloth.insuredme.domain.Question;
import com.sleepingsloth.insuredme.domain.QuestionType;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	public Iterable<Question> findByType(@Param("questionType") QuestionType questionType);
}
