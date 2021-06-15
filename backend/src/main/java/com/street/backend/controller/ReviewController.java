package com.street.backend.controller;

import com.street.backend.entity.Review;
import com.street.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            return ResponseEntity.of(review);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

}
