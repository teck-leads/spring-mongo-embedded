package com.techleads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.techleads.app.repository.UserMongoRepository;
@EnableMongoRepositories(basePackageClasses = UserMongoRepository.class)
@SpringBootApplication
public class SpringMongoEmbeddedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoEmbeddedApplication.class, args);
	}

}
