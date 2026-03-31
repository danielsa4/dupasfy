package com.dupas.fy;

import se.michaelthelin.spotify.model_objects.specification.Track;

import java.time.LocalDate;
import java.util.List;

public interface TrackContainer {
    List<Track> getTracks();
    String getTitle();
    List<String> getTags();
    LocalDate getReleaseDate();
    List<String> getArtists();
}
