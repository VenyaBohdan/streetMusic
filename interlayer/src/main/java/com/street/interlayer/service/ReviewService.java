package com.street.interlayer.service;

import com.street.interlayer.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    Review getReviewById(Long id);
    List<Review> getAllReviews();
    Review saveReview(Review review);
    void deleteReview(Long id);

}
