package cz.tipsport.elastic.apm.simpleservice.client.service;



import cz.tipsport.elastic.apm.simpleservice.client.entity.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        // set connection and read timeouts
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
    }

    public String getUserPlainJSON() {
        String url = "http://localhost:8080/api/v1/users";
        return this.restTemplate.getForObject(url, String.class);
    }

    public User[] getUsersAsObject() {
        String url = "http://localhost:8080/api/v1/users";
        return this.restTemplate.getForObject(url, User[].class);
    }

    public User getUserWithUrlParameters() {
        String url = "http://localhost:8080/api/v1/users/{id}";
        return this.restTemplate.getForObject(url, User.class, 1);
    }

    public User getUserWithResponseHandling() {
        String url = "http://localhost:8080/api/v1/users/{id}";
        ResponseEntity<User> response = this.restTemplate.getForEntity(url, User.class, 1);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}