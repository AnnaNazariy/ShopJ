package com.example.service_reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceReviewsApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceReviewsApplication.class, args);
	}
}
