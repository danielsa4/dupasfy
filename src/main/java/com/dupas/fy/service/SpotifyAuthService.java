package com.dupas.fy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.dupas.fy.dto.TokenResponse;

import java.util.Map;

@Service
public class SpotifyAuthService {

    private final RestClient restClient;
    private boolean logged;

    public SpotifyAuthService() {
        this.restClient = RestClient.create();
    }

    public TokenResponse getToken() {
        // System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEE");
        TokenResponse response = restClient.get()
            .uri("http://127.0.0.1:8080/get_token")
            .retrieve()
            .body(TokenResponse.class);
        return response;
    }

    public boolean getLoggingStatus() {
        Map<String, Object> response = restClient.get()
            .uri("http://127.0.0.1:8080/is_logged")
            .retrieve()
            .body(Map.class);
        this.logged = (boolean) response.get("logged");
        return this.logged;
    }
}
