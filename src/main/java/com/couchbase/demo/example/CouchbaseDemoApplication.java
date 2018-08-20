package com.couchbase.demo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
public class CouchbaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouchbaseDemoApplication.class, args);
	}
}
	