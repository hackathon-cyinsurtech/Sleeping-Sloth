package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sleepingsloth.insuredme.domain.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
	
	public Iterable<Photo> findByQuoteRequestId(@Param("quoteRequestId") long quoteRequestId);
}
