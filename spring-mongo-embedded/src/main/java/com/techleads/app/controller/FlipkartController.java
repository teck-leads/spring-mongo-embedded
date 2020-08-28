package com.techleads.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.User;
import com.techleads.app.repository.UserMongoRepository;

@RestController
public class FlipkartController {
	@Autowired
	private UserMongoRepository userMongoRepository;

	@PostMapping(value = "/users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User save = userMongoRepository.save(user);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@GetMapping(value = "/users/{name}")
	public ResponseEntity<User> findByName(@PathVariable("name") String name) {
		User save = userMongoRepository.findByName(name);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}

	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> findAllUsers() {
		List<User> findAll = userMongoRepository.findAll();
		return new ResponseEntity<>(findAll, HttpStatus.OK);
	}

	@GetMapping(value = "/users/addrs/{city}")
	public ResponseEntity<List<User>> findUsersByCity(@PathVariable("city") String city) {
		List<User> usersByCity = userMongoRepository.findByCity(city);

		return new ResponseEntity<>(usersByCity, HttpStatus.OK);
	}

}
