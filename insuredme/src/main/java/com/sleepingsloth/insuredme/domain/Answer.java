package com.sleepingsloth.insuredme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long quoteRequestId;
	
	private long questionId;
	
	private String answer;

	public long getQuoteRequestId() {
		return quoteRequestId;
	}

	public void setQuoteRequestId(long quoteRequestId) {
		this.quoteRequestId = quoteRequestId;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public long getId() {
		return id;
	}

}
