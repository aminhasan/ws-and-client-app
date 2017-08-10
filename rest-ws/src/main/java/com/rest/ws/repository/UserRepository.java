package com.rest.ws.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.ws.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsernameAndPassword(String username, String password);
}
