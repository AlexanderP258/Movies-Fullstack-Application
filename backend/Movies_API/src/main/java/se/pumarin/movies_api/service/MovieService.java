package se.pumarin.movies_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.pumarin.movies_api.model.Movie;
import se.pumarin.movies_api.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    @Override
    public Movie save(Movie film) {
        return movieRepository.save(film);
    }
}
