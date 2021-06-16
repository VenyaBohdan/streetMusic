package com.street.interlayer.service.impl;

import com.street.interlayer.model.Review;
import com.street.interlayer.service.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ReviewServiceImpl implements ReviewService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    private final String REVIEW = "review/";

    @Override
    public Review getReviewById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + REVIEW + id, Review.class);
    }

    @Override
    public List<Review> getAllReviews() {
        RestTemplate restTemplate = new RestTemplate();
        Review[] reviewResponse = restTemplate.getForObject(backendServerUrl + REVIEW, Review[].class);
        return reviewResponse == null ? Collections.emptyList() : Arrays.asList(reviewResponse);
    }

    @Override
    public Review saveReview(Review review) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + REVIEW, review, Review.class).getBody();
    }

    @Override
    public void deleteReview(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + REVIEW + id);
    }
}
