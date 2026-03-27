package com.dupas.fy;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.tracks.GetTrackRequest;

import java.time.LocalDate;
import java.util.List;

public interface TrackContainer {
    List<Track> getTracks();
    String getTitle();
    List<String> getTags();
    LocalDate getReleaseDate();
    List<String> getArtists();
}
