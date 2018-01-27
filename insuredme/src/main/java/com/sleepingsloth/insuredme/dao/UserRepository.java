package com.sleepingsloth.insuredme.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sleepingsloth.insuredme.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("from User u where u.email=:email and u.password = :password")
	public List<User> loadUser(@Param("email") String email, @Param("password") String password);

	public User findTopByEmail(@Param("email") String email);
}

