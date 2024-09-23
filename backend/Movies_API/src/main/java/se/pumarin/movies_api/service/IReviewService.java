package se.pumarin.movies_api.service;

import se.pumarin.movies_api.model.Review;

public interface IReviewService {
    Review createReview(String reviewBody, String imdbId);
}
