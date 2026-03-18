package com.dupas.fy;


public class Album {
	String name;
	private String[] artists;
	private String[] tags;
	private String date_of_release;

	public Album(){}
	public Album(String new_name, String[] new_artists) {
		this.name = new_name;
		this.artists = new_artists;
	}
}

