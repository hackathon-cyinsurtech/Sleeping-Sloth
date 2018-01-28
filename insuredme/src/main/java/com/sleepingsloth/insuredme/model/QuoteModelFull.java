package com.sleepingsloth.insuredme.model;

import java.util.List;

import com.sleepingsloth.insuredme.domain.Answer;
import com.sleepingsloth.insuredme.domain.QuoteRequest;
import com.sleepingsloth.insuredme.domain.User;

public class QuoteModelFull {

	private QuoteRequest quoteRequest;

	private Iterable<Answer> answers;
	
	private User user;

	public QuoteRequest getQuoteRequest() {
		return quoteRequest;
	}

	public void setQuoteRequest(QuoteRequest quoteRequest) {
		this.quoteRequest = quoteRequest;
	}

	public Iterable<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Iterable<Answer> answers) {
		this.answers = answers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
