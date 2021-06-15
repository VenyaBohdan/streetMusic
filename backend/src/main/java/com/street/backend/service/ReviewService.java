package com.street.backend.service;

import com.street.backend.entity.Review;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReviewService {

    Iterable<Review> getAllReviews();
    Optional<Review> getReviewById(Long id);
    Review saveReview(Review review);
    void deleteReview(Long id);

}
