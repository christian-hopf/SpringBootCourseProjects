package com.example.restcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.restcrud"})
public class RestcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestcrudApplication.class, args);
	}

}
