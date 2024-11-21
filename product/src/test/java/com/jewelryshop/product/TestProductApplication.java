package com.jewelryshop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestProductApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductApplication::main)
				.with(TestcontainersConfiguration.class)
				.run(args);
	}
}
