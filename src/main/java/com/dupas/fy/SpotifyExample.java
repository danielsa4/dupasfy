package com.dupas.fy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.github.cdimascio.dotenv.Dotenv;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

public class SpotifyExample {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String CLIENT_ID = dotenv.get("SPOTIFY_CLIENT_ID");
    private static final String CLIENT_SECRET = dotenv.get("SPOTIFY_CLIENT_SECRET");


    static void createCSV(Track trk, int ind) {
        String content = ind + ", " + trk.getName() + ".";
        Path file = Path.of("./output/music.csv"); // The file will be created in the project's root directory

        try {
            Files.writeString(file, content);
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        System.out.println("Client ID: " + CLIENT_ID);
        System.out.println("Client SECRET: " + CLIENT_SECRET);
        try {
            SpotifyApi spotifyApi = new SpotifyApi.Builder()
                    .setClientId(CLIENT_ID)
                    .setClientSecret(CLIENT_SECRET)
                    .build();

            // Autenticação
            ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            // ID da música (exemplo: Shape of You)
            String trackId = "7qiZfU4dY1lWllzX7mPBI3";

            GetTrackRequest getTrackRequest = spotifyApi.getTrack(trackId).build();
            Track track = getTrackRequest.execute();

            // Impressão das informações
            System.out.println("Nome: " + track.getName());
            System.out.println("Artista: " + track.getArtists()[0].getName());
            System.out.println("Álbum: " + track.getAlbum().getName());
            System.out.println("Duração (ms): " + track.getDurationMs());
            System.out.println("Duração (ms): " + track.getExternalIds());

            createCSV(track, 1);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
