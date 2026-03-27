package com.dupas.fy;
import com.dupas.fy.TrackContainer;
import org.springframework.cglib.core.Local;
import se.michaelthelin.spotify.model_objects.specification.Track;

import java.time.LocalDate;
import java.util.List;

public class Ep implements TrackContainer {
    private String epName;
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
