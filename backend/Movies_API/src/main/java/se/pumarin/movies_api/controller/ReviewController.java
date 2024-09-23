package se.pumarin.movies_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.pumarin.movies_api.dto.ReviewUpdateDTO;
import se.pumarin.movies_api.model.Review;
import se.pumarin.movies_api.service.ReviewService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;


import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping()
    @RateLimiter(name = "createReview", fallbackMethod = "createReviewFallback")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Review>> updateReview(@PathVariable String id, @RequestBody ReviewUpdateDTO payload) {
        Optional<Review> updatedReview = service.updateReview(id, payload.getBody());
        return updatedReview.isPresent()
                ? new ResponseEntity<>(updatedReview, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id) {
        boolean isDeleted = service.deleteReview(id);
        if (isDeleted) {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
        }
    }



}
