package com.dupas.fy.util;

import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.requests.data.playlists.RemoveItemsFromPlaylistRequest;

public class PlaylistHandler {
    // Deleta de todas as playlists
    void delete_song(Song remove){
        
    }
    void delete_song(User current_user, Song remove, Playlist[] remove_from){

        // RemoveItemsFromPlaylistRequest.Builder request_builder = (current_user.getAccess_token());
        // request_builder.playlist_id(remove_from[0].getId()); 
        // RemoveItemsFromPlaylistRequest remove_request;
        // remove_request.execute();
    }
    // Deleta de todas suas playlists todas as musicas com artista x
    void delete_artist(ArtistSimplified remove){

    }
    void delete_artist(ArtistSimplified remove, Playlist[] remove_from){

    }
    
}
