package com.dupas.fy.autentication;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import java.net.URI;

import com.dupas.fy.SpotifyService;

public class SpotifyAuth {
    public static void main(String[] args) throws Exception {
        SpotifyService service = new SpotifyService();

        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(service.getApi().getClientId())
                .setClientSecret(service.getApi().getClientSecret())
                .setRedirectUri(URI.create("http://127.0.0.1:8080/callback")) // Must match Spotify Dashboard exactly
                .build();

        AuthorizationCodeUriRequest authorizationUriRequest = spotifyApi.authorizationCodeUri()
                .scope(/*"playlist-modify-public", "playlist-modify-private"*/)
                .state("secure_random_state_string") // Prevent CSRF attacks
                .show_dialog(true)
                .build();

        URI authUri = authorizationUriRequest.execute();
        System.out.println("Open this URL in your browser:\n" + authUri);
        System.out.println("Waiting for you to authorize...");
    }
}
