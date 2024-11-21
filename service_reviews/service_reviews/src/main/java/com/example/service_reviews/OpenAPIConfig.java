package com.example.service_reviews;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI serviceReviewsAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Service Reviews API")
                        .description("This is the REST API for managing product reviews")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")));
    }
}
