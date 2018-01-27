package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sleepingsloth.insuredme.domain.Offer;

public interface OfferRepository extends CrudRepository<Offer, Long> {

	public Iterable<Offer> findByUserIdOrderById(@Param("userId") long userId);
	
	public Iterable<Offer> findByQuoteRequestIdOrderByPrice(@Param("quoteRequestId") long quoteRequestId);
}

