package se.pumarin.movies_api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import se.pumarin.movies_api.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}