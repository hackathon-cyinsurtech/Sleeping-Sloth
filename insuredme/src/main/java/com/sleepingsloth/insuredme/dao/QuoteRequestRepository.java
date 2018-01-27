package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;

import com.sleepingsloth.insuredme.domain.QuoteRequest;

public interface QuoteRequestRepository extends CrudRepository<QuoteRequest, Long> {
	
}
