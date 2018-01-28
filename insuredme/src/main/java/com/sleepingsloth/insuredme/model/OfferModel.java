package com.sleepingsloth.insuredme.model;

import com.sleepingsloth.insuredme.domain.Offer;
import com.sleepingsloth.insuredme.domain.User;

public class OfferModel {
	
	private Offer offer;
	
	private User user;

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
