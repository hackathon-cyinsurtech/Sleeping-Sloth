package com.sleepingsloth.insuredme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long quoteRequestId;
	
	private long userId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public long getQuoteRequestId() {
		return quoteRequestId;
	}

	public void setQuoteRequestId(long quoteRequestId) {
		this.quoteRequestId = quoteRequestId;
	}
}
