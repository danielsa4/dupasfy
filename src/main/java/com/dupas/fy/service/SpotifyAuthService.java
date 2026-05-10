package com.dupas.fy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SpotifyAuthService {

    private final RestClient restClient;

    public SpotifyAuthService() {
        this.restClient = RestClient.create();
    }

    public String getToken() {

        String response = restClient.get()
                .uri("http://127.0.0.1:8080/get_token")
                .retrieve()
                .body(String.class);

        return response;
    }
}
