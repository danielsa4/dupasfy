package com.dupas.fy;


public class Album {
    private String name;
    private String[] artists;
    private String[] tags;
    private String date_of_release;
	
	public Album(){}

    public Album(String new_name) {
	this.name = new_name;		
    }
    
    public Album(String new_name, String[] new_artists) {
        this.name = new_name;
        this.artists = new_artists;
    }
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   
    public String[] getArtists() {
        return artists;
    }
    
    public void setArtists(String[] new_artists) {
        this.artists = new_artists;
    }
    
    public String[] getTags() {
        return tags;
    }
    
    public void setTags(String[] tags) {
        this.tags = tags;
    }
   
    public String getDate_of_release() {
        return date_of_release;
    }
    
    public void setDate_of_release(String date_of_release) {
        this.date_of_release = date_of_release;
    }
}








