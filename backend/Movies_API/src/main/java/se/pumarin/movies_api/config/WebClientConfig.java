package se.pumarin.movies_api.config;

import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder () {
        return WebClient.builder();
    }
}

