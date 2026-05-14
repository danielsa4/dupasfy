package com.dupas.fy.util;

import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistsItemsRequest;

import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import com.dupas.fy.dto.TokenResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String account;
    private Song[] history;
    private final RestClient restClient;
    private boolean isAuthenticated;
    private String access_token;
  
    public User(){
        this.restClient = RestClient.create();
    }

    public User(String new_account){
		this.account = new_account;
        this.restClient = RestClient.create();
	}

    public void isAuthServerOn() {
        try (Socket socket = new Socket("localhost", 8080)) {
            this.isAuthenticated = true;
        } catch (IOException e) {
            this.isAuthenticated = false; 
        }
    }

    public void checkLogin() {
        System.out.println("Checking the login information...");

        boolean response = restClient.get()
            .uri("http://127.0.0.1:3000/auth/get-is-logged")
            .retrieve()
            .body(Boolean.class);
        if (response) {
            System.out.println("You're already logged!");
        } else {
            System.out.println("You're not logged yet. Clink on the link to authenticate: http://127.0.0.1:8080/");
        }
    }

    public void requestAccessToken() {
        TokenResponse token_response = restClient.get()
            .uri("http://127.0.0.1:3000/auth/get-token")
            .retrieve()
            .body(TokenResponse.class);
        this.access_token = token_response.getAccess_token();
    }

    public void writePlaylistCSV(Playlist playlist) {
    //     try {
    //         GetPlaylistsItemsRequest request = spotifyApi
    //                 .getPlaylistsItems(playlistId)
    //                 .build();

    //         Paging<PlaylistTrack> paging = request.execute();

    //         for (PlaylistTrack item : paging.getItems()) {
    //             if (item.getTrack() instanceof Track) {
    //                 Track track = (Track) item.getTrack();
    //                 System.out.println(track.getName());
    //             }
    //         }

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    }
}
