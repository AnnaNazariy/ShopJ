package com.example.service_reviews;

public record ReviewResponse(
        Long id,
        Long productId,
        String reviewerName,
        Integer rating,
        String comment,
        String reviewDate) {}
