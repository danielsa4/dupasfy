package com.dupas.fy.util;

import io.github.cdimascio.dotenv.Dotenv;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;
import se.michaelthelin.spotify.requests.data.artists.GetArtistRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistRequest;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistsItemsRequest;
public class SpotifyService {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String CLIENT_ID = dotenv.get("SPOTIFY_CLIENT_ID");
    private static final String CLIENT_SECRET = dotenv.get("SPOTIFY_CLIENT_SECRET");

    private final SpotifyApi spotifyApi;

    public SpotifyService() {
        SpotifyApi tempApi = null;
        try {
            tempApi = new SpotifyApi.Builder()
                    .setClientId(CLIENT_ID)
                    .setClientSecret(CLIENT_SECRET)
                    .build();

            // Autenticação
            ClientCredentialsRequest clientCredentialsRequest = tempApi.clientCredentials().build();
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            tempApi.setAccessToken(clientCredentials.getAccessToken());
        } catch (Exception e) {
            throw new RuntimeException("Erro", e);
        }
        this.spotifyApi = tempApi;
    }

    public SpotifyApi getApi() {
        return this.spotifyApi;
    };
    
    public Track getTrack(String trackId){
        RequestHandler<Track> handler = new RequestHandler<>();
        GetTrackRequest request = spotifyApi.getTrack(trackId).build();
        return handler.executeSpotifyRequest(request);
    }

    public Album getAlbum(String albumId){
        RequestHandler<Album> handler = new RequestHandler<>();
        GetAlbumRequest request = spotifyApi.getAlbum(albumId).build();
        return handler.executeSpotifyRequest(request);
    }

    public Artist getArtist(String artistId){
        RequestHandler<Artist> handler = new RequestHandler<>();
        GetArtistRequest request = spotifyApi.getArtist(artistId).build();
        return handler.executeSpotifyRequest(request);
    }

    public Playlist getPlaylist(String playlistId){
        RequestHandler<Playlist> handler = new RequestHandler<>();
        GetPlaylistRequest request = spotifyApi.getPlaylist(playlistId).build();
        return handler.executeSpotifyRequest(request);
    }

    public Paging<PlaylistTrack> getPlaylistItems(String playlistId) {

        try {
            GetPlaylistsItemsRequest request = spotifyApi
                    .getPlaylistsItems(playlistId)
                    .build();

            Paging<PlaylistTrack> paging = request.execute();
            // printar os itens no console
            return paging;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ExecutorService exec = Executors.newFixedThreadPool(10);

        // //getItems paralelo -> Não preserva a ordem
        // for (PlaylistTrack item : paging.getItems()) {

        //     exec.submit(() ->
        //             {
        //                 if (item.getTrack() instanceof Track) {
        //                     Track track = (Track) item.getTrack();
        //                     System.out.println(track.getName());
        //                 }
        //             }
        //             );

        // }



        return null;
    }

}
