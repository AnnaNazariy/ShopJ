package com.example.service_reviews;

import org.springframework.boot.SpringApplication;

public class TestServiceReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.from(ServiceReviewsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
