package com.dupas.fy;

import se.michaelthelin.spotify.model_objects.specification.Track;

import java.time.LocalDate;
import java.util.List;

import com.dupas.fy.TrackContainer;


public class Album implements TrackContainer {
    private String albumName;
    private List<String> artists;
    private List<String> tags;
    private LocalDate dateOfRelease;

    @Override
    public List<Track> getTracks() {
        return null;
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public List<String> getTags(){
        return null;
    }

    @Override
    public LocalDate getReleaseDate(){
        return null;
    }

    @Override
    public List<String> getArtists(){
        return null;
    };

}








