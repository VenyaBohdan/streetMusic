package com.street.interlayer.controller;

import com.street.interlayer.model.Review;
import com.street.interlayer.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Review> getReviewById(@PathVariable String id) {
        return ResponseEntity.ok(reviewService.getReviewById(Long.valueOf(id)));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Review> saveReview(@RequestBody Review review) {
        if (review != null) {
            return ResponseEntity.ok(reviewService.saveReview(review));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBand(@PathVariable String id) {
        reviewService.deleteReview(Long.valueOf(id));
    }

}
