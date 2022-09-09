package br.com.bookservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Tag(name = "foo bar")
@RestController
@RequestMapping("book-service")
@Slf4j
public class FooBarController {

    @GetMapping("/foo-bar")
//    @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
//    @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod"
//    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    @Operation(summary = "foo bar")
    public String fooBar(){
        log.info("Request to foo-bar is received!");

//        var response = new RestTemplate()
//                .getForEntity("http://localhost:8000/foo-bar", String.class);
//        return response.getBody();
        return "foo-bar!!";
    }

    public String fallbackMethod(Exception ex){

        return "fallbackMethod foo-bar";

    }
}
