package com.dupas.fy;

import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Playlist;
import se.michaelthelin.spotify.model_objects.specification.PlaylistTrack;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.playlists.GetPlaylistsItemsRequest;


public class User {
    private String account;
    private Song[] history;
    
  
    public User(){}

    public User(String new_account){
		this.account = new_account;
	}

    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
   
    public Song[] getHistory() {
        return history;
    }
    
    public void setHistory(Song[] history) {
        this.history = history;
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
