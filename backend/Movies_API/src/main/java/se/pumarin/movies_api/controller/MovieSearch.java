package se.pumarin.movies_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import se.pumarin.movies_api.model.Movie;
import se.pumarin.movies_api.response.ErrorResponse;
import se.pumarin.movies_api.service.IMovieService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/search")
@CrossOrigin(origins = "*")
public class MovieSearch {

    @Value("${tmdb_api_key}")
    private String apiKey;

    @Autowired
    private IMovieService movieService;

    private final WebClient webClientConfig;

    public MovieSearch (WebClient.Builder webClient, IMovieService movieService) {
        this.webClientConfig = webClient
                .baseUrl("https://api.themoviedb.org/3/")
                .build();
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFilmById(@RequestParam(defaultValue = "movie") String movie, @PathVariable int id) {

        try {

            Optional<Movie> response = Optional.ofNullable(
                    webClientConfig.get()
                            .uri(film -> film
                                    .path(movie + "/" + id)
                                    .queryParam("api_key", apiKey)
                                    .build())
                            .retrieve()
                            .bodyToMono(Movie.class)
                            .block()
            );


            if (response.isPresent()) {
                return ResponseEntity.ok(response.get());
            } else {
                return ResponseEntity.status(404).body(new ErrorResponse("Movie not found"));
            }

        } catch (WebClientResponseException e) {

            return ResponseEntity.status(404).body(new ErrorResponse("Movie not found"));
        }
    }
}
