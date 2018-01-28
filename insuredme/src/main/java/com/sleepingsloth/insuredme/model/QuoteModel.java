package com.sleepingsloth.insuredme.model;

import com.sleepingsloth.insuredme.domain.QuoteRequest;

public class QuoteModel {

	private QuoteRequest quoteRequest;
	private String carRegistrationNumber;
	public QuoteRequest getQuoteRequest() {
		return quoteRequest;
	}
	public void setQuoteRequest(QuoteRequest quoteRequest) {
		this.quoteRequest = quoteRequest;
	}
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}
	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}
}
