package se.pumarin.movies_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    // MongoDB's internal ObjectId
    @Id
    private ObjectId db_id;

    // API-specific integer id
    @JsonProperty("id")
    private int externalId;


    @JsonProperty("imdb_id")
    private String imdbId;

    private String title;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("poster_path")
    private String poster;

    private String overview;
    private int budget;
    private int revenue;
    private int runtime;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @Transient
    private List<Genre> genres;

    @JsonProperty("belongs_to_collection")
    private BelongsToCollection belongsToCollection;

    @DocumentReference
    private List<Review> reviewIds;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class BelongsToCollection {
    private int id;
    private String name;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("backdrop_path")
    private String backdropPath;
}
