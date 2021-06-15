package com.street.backend.service.impl;

import com.street.backend.entity.Review;
import com.street.backend.repository.ReviewRepository;
import com.street.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Iterable<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

}
