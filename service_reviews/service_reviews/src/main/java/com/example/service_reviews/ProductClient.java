package com.example.service_reviews;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "products", url = "${product.url}")
public interface ProductClient {
    @GetMapping("/api/product/stock")
    boolean isInStock(@RequestParam("productId") Long productId);
}
