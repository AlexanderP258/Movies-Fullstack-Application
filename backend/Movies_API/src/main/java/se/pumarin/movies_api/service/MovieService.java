package se.pumarin.movies_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.pumarin.movies_api.model.Movie;
import se.pumarin.movies_api.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }
}
