package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;

import com.sleepingsloth.insuredme.domain.Offer;

public interface OfferRepository extends CrudRepository<Offer, Long> {
	
}

