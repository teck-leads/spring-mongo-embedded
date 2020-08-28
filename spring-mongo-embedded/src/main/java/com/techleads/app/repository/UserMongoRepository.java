package com.techleads.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.techleads.app.model.User;

public interface UserMongoRepository extends MongoRepository<User, Integer>{
	
	User findByName(String name);
	@Query("{'Address.city':?0}")
	List<User> findByCity(String cityName);
}
