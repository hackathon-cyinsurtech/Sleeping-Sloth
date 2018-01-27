package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;

import com.sleepingsloth.insuredme.domain.InsuranceType;

public interface InsuranceTypeRepository extends CrudRepository<InsuranceType, String> {
	
}
