package com.sleepingsloth.insuredme.dao;

import org.springframework.data.repository.CrudRepository;

import com.sleepingsloth.insuredme.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
}
