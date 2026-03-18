package com.dupas.fy;


public class Playlist {
    private String name;
    private Song[] selected_songs;
    
    public Playlist(){}
    
    public Playlist(String new_name){
    	this.name = new_name;
    }

    public Playlist(String new_name, Song[] new_songs){
    	this.name = new_name;
            this.selected_songs = new_songs;
    }    
   
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
      public Song[] getSelected_songs() {
        return selected_songs;
    }
    
    public void setSelected_songs(Song[] selected_songs) {
        this.selected_songs = selected_songs;
    }
}

