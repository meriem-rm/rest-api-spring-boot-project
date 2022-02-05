package com.example.demo.user;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
	// JPA has a method that filters things by classname 
	public List<User> findByLocationId(String locationId); // findby<classname>id 
	
	public List<User> findByfirstname(String name);
}
