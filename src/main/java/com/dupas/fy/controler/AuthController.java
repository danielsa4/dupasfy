package com.dupas.fy.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.dupas.fy.dto.TokenResponse;
import com.dupas.fy.service.SpotifyAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private SpotifyAuthService spotifyAuthService;

    public AuthController(SpotifyAuthService spotifyAuthService) {
        this.spotifyAuthService = spotifyAuthService;
    }

    // GET Request: localhost:3000/auth/get-token
    @GetMapping("/get-token")
    public TokenResponse getToken() {
        return spotifyAuthService.getToken();
    }

    @GetMapping("/get-is-logged")
    public boolean isLogged() {
        return spotifyAuthService.getLoggingStatus();
    }

}
