package se.pumarin.movies_api.service;

import se.pumarin.movies_api.model.Review;

import java.util.Optional;

public interface IReviewService {
    Review createReview(String reviewBody, String imdbId);
    Optional<Review> updateReview(String id, String reviewBody);
    boolean deleteReview(String id);
}
