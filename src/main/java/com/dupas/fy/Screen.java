package com.dupas.fy;

import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Playlist;

import com.dupas.fy.Song;

public class Screen {
    Screen() {
        System.out.println("Welcome to Dupasfy!");
    }

    void showOptions() {
        System.out.println(" ");
        System.out.println("Options: ");
        System.out.println("1. Search for a song");
        System.out.println("2. Search for an album");
        System.out.println("3. Search for an artist");
        System.out.println("4. Search for an playlist");
        System.out.println("5. Show searched items");
        System.out.println("6. Exit");
    }

    <T> void showInfo(T spotifyObject) {
        String line = "================================";
        if (spotifyObject instanceof Song) {
            Song song = (Song) spotifyObject;
            System.out.println(line);
            System.out.println("Id: " + song.getId());
            System.out.println("Name: " + song.getName());
            System.out.println("Artist: " + song.getArtists());
            System.out.println(line);

        } else if (spotifyObject instanceof Album) {
            Album album = (Album) spotifyObject;
            System.out.println(line);
            System.out.println("Id: " + album.getId());
            System.out.println("Name: " + album.getName());
            System.out.println("Release date: " + album.getReleaseDate());
            System.out.println(line);
            
        } else if (spotifyObject instanceof Artist) {
            Artist artist = (Artist) spotifyObject;
            System.out.println(line);
            System.out.println("Id: " + artist.getId());
            System.out.println("Name: " + artist.getName());
            System.out.println("Popularity: " + artist.getPopularity());
            System.out.println(line);
            
        } else if (spotifyObject instanceof Playlist) {
            Playlist playlist = (Playlist) spotifyObject;
            System.out.println(line);
            System.out.println("Id: " + playlist.getId());
            System.out.println("Name: " + playlist.getName());
            System.out.println("Description: " + playlist.getDescription());
            System.out.println(line);

        } else {
            System.out.println("Unsupported object type");
        }
    }
}
