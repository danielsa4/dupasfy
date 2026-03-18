package com.dupas.fy;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

public class SpotifyExample {

    private static final String CLIENT_ID = "5b71ee21d52a4c6693153565e6799cb6";
    private static final String CLIENT_SECRET = "f83d3cbb65594a81b13f4bf17b53bc8f";

    public static void main(String[] args) {
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

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
