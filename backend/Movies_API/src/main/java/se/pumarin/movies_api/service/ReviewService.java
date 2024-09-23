package se.pumarin.movies_api.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.pumarin.movies_api.model.Review;
import se.pumarin.movies_api.repository.ReviewRepository;

import java.util.Optional;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));
        return review;
    }

    @Override
    public Optional<Review> updateReview(String id, String reviewBody) {
        Optional<Review> existingReview = reviewRepository.findById(new ObjectId(id));

        if (existingReview.isPresent()) {
            Review review = existingReview.get();
            review.setBody(reviewBody);
            reviewRepository.save(review);
            return Optional.of(review);
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteReview(String id) {
        Optional<Review> existingReview = reviewRepository.findById(new ObjectId(id));

        if (existingReview.isPresent()) {
            reviewRepository.deleteById(new ObjectId(id));
            return true;
        }

        return false;
    }


}
