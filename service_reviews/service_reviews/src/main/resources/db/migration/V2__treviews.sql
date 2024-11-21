CREATE TABLE `service_reviews.reviews` (
                                           `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                           `product_id` BIGINT(20) NOT NULL,
                                           `reviewer_name` VARCHAR(255) NOT NULL,
                                           `rating` INT(11) NOT NULL,
                                           `comment` TEXT,
                                           `review_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP

);

