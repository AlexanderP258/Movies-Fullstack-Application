package se.pumarin.movies_api.config;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class SecurityConfig {

    @Bean
    public RateLimiter rateLimiter() {

        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(1)
                .limitRefreshPeriod(Duration.ofSeconds(30))
                .timeoutDuration(Duration.ofSeconds(5))
                .build();


        return RateLimiter.of("myRateLimiter", config);
    }
}