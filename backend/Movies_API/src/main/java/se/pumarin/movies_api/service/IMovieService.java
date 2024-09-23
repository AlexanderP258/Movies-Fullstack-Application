package se.pumarin.movies_api.service;

import se.pumarin.movies_api.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> allMovies();
}
