package com.dupas.fy.util;

import java.io.IOException;

import com.dupas.fy.dto.StringJsonConverter;
import com.google.gson.JsonArray;

import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.requests.data.playlists.RemoveItemsFromPlaylistRequest;

public class PlaylistHandler {
    // Deleta de todas as playlists
    void delete_song(Song remove){
        
    }

    // Deleta uma musica de x playlists
    void delete_song(User current_user, Song remove, Playlist[] remove_from){

         RemoveItemsFromPlaylistRequest.Builder request_builder = new RemoveItemsFromPlaylistRequest.Builder(current_user.getAccess_token());
         

         request_builder.playlist_id(remove_from[0].getId()); 
         
         StringJsonConverter util = new StringJsonConverter();

         JsonArray jsonArray = new JsonArray();
         
         jsonArray.add(util.object_json(remove));
         
         request_builder.tracks( jsonArray );
         

         RemoveItemsFromPlaylistRequest remove_request;
         remove_request = request_builder.build();
         

         
         RequestHandler<RemoveItemsFromPlaylistRequest> handler = new RequestHandler<>();
         
        try {
             remove_request.execute();
        } catch (IOException | ParseException | SpotifyWebApiException e) {
            throw new RuntimeException(e);
        }

         //handler.executeSpotifyRequest(remove_request);
    }
    // Deleta de todas suas playlists todas as musicas com artista x
    void delete_artist(ArtistSimplified remove){

    }
    void delete_artist(ArtistSimplified remove, Playlist[] remove_from){

    }
    
}
