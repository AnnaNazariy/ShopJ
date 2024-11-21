package com.example.laba4;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

import static org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions.setPath;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

@Configuration(proxyBeanMethods = false)
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> productsServiceRoute() {
        return RouterFunctions.route(RequestPredicates.path("/api/product"),
                request -> ServerResponse.temporaryRedirect(URI.create("http://localhost:8081")).build());
    }
    @Bean
    public RouterFunction<ServerResponse> productServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("product_swagger")
                .route(RequestPredicates.path("/aggregate/product/v3/api-docs"),
                        http(System.getenv("PRODUCT_URL")))
                .filter(setPath("/api-docs"))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> service_reviewsServiceRoute() {
        return RouterFunctions.route(RequestPredicates.path("/api/reviews"),
                request -> ServerResponse.temporaryRedirect(URI.create("http://localhost:8082")).build());
    }
    @Bean
    public RouterFunction<ServerResponse> reviewServiceSwaggerRoute() {
        return GatewayRouterFunctions.route("review_service_swagger")
                .route(RequestPredicates.path("/aggregate/review-service/v3/api-docs"),
                        http(System.getenv("REVIEW_URL")))
                .filter(setPath("/api-docs"))
                .build();
    }
}
