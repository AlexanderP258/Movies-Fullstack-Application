package se.pumarin.movies_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.pumarin.movies_api.model.Review;
import se.pumarin.movies_api.service.ReviewService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")

public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
