package com.dupas.fy;


public class Song {
    private String name;
    private Album album;
    private String[] artists;
    private int duration;
    private int bpm;
    private int popularity;
    private String date_of_stream;
    
   public Song(){}
   public Song(String new_name){
	this.name = new_name;
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
    
   
    public String[] getArtists() {
        return artists;
    }
    
    public void setArtists(String[] artists) {
        this.artists = artists;
    }
    
   
    public int getDuration() {
        return duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
   
    public int getBpm() {
        return bpm;
    }
    
    public void setBpm(int bpm) {
        this.bpm = bpm;
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



