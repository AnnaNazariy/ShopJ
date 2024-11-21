package com.example.service_reviews;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ReviewService {
    private static final Logger log = LoggerFactory.getLogger(ReviewService.class);
    private final ReviewRepository reviewRepository;
    private final ProductClient productClient;

    public ReviewService(ReviewRepository reviewRepository, ProductClient productClient) {
        this.reviewRepository = reviewRepository;
        this.productClient = productClient;
    }

    public void createReview(ReviewRequest reviewRequest) {
        boolean isProduct = this.productClient.isInStock(reviewRequest.productId());
        if (isProduct) {
            Review review = new Review();
            review.setProductId(reviewRequest.productId());
            review.setReviewerName(reviewRequest.reviewerName());
            review.setRating(reviewRequest.rating());
            review.setComment(reviewRequest.comment());

            if (reviewRequest.reviewDate() == null) {
                review.setReviewDate(String.valueOf(LocalDate.now()));
            } else {
                review.setReviewDate(reviewRequest.reviewDate());
            }

            this.reviewRepository.save(review);
            log.info("Review for product {} is saved", review.getProductId());
        } else {
            log.warn("Product {} is not in stock", reviewRequest.productId());
        }
    }


    public List<ReviewResponse> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(this::mapToReviewResponse).toList();
    }

    private ReviewResponse mapToReviewResponse(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getProductId(),
                review.getReviewerName(),
                review.getRating(),
                review.getComment(),
                review.getReviewDate()
        );
    }
}
