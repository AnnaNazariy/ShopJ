package com.example.service_reviews;

public record ReviewRequest(
        Long productId,
        String reviewerName,
        Integer rating,
        String comment,
        String reviewDate) {}
