package com.dupas.fy;

import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;

import com.dupas.fy.Album;

public class Song {
    private String name;
    private Album album;
    private ArtistSimplified[] artists;
    private int duration;
    private int popularity;
    private String date_of_stream;
    
    public Song(Track new_track, Album ab) {
        this.name = new_track.getName();
        this.album = ab;
        this.artists = new_track.getArtists();
        this.duration = new_track.getDurationMs();
        this.popularity = new_track.getPopularity();
        this.date_of_stream = new_track.getAlbum().getReleaseDate();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
   
    public Album getAlbum() {
        return album;
    }
    
    public void setAlbum(Album album) {
        this.album = album;
    }
    
   
    public ArtistSimplified[] getArtists() {
        return artists;
    }
    
    public void setArtists(ArtistSimplified[] artists) {
        this.artists = artists;
    }
    
   
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
   
    public int getPopularity() {
        return popularity;
    }
    
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
    
    public String getDate_of_stream() {
        return date_of_stream;
    }
    
    public void setDate_of_stream(String date_of_stream) {
        this.date_of_stream = date_of_stream;
    }
}
