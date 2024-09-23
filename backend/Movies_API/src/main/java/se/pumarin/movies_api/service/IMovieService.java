package se.pumarin.movies_api.service;

import se.pumarin.movies_api.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> allMovies();
    Optional<Movie> singleMovie(String imdbId);
    Movie save (Movie film);
}
