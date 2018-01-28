package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sleepingsloth.insuredme.domain.QuoteRequest;

public interface QuoteRequestRepository extends CrudRepository<QuoteRequest, Long> {
	
	public Iterable<QuoteRequest> findByUserIdOrderById(@Param("userId") long userId);
	
	public Iterable<QuoteRequest> findByPhotosTakenAndOpen(@Param("photosTaken") boolean photosTaken, @Param("open") boolean open);

}
