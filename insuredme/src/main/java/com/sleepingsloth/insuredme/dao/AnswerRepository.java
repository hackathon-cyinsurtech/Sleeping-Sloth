package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sleepingsloth.insuredme.domain.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	
	public Answer findTopByQuoteRequestIdAndQuestionId(@Param("quoteRequestId") long quoteRequestId, @Param("questionId") long questionId);

	public Iterable<Answer> findByQuoteRequestId(@Param("quoteRequestId") long quoteRequestId);
}
