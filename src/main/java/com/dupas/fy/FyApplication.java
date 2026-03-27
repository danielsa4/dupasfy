package com.dupas.fy;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dupas.fy.SpotifyService;
import com.dupas.fy.Song;
import se.michaelthelin.spotify.model_objects.specification.Album;

@SpringBootApplication
public class FyApplication {
	public static void main(String[] args) {
		SpringApplication.run(FyApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		
		try {
			while (true) {
				System.out.println(" ");
				System.out.println("Options: ");
				System.out.println("1. Search for a song");
				System.out.println("2. Search for an album");
				System.out.println("3. Search for an artist");
				System.out.println("4. Exit");
				int option = scanner.nextInt();
				scanner.nextLine(); // consume the newline
					
				if (option == 1) {
					System.out.println("Give the id of a song: ");
					String idOption = scanner.nextLine();
					System.out.println("Searching for a song...");
					SpotifyService service = new SpotifyService();
					var track = service.getTrack(idOption);
					// var album = track.getAlbum();
					System.out.println("Id: " + track.getId());
					System.out.println("Name: " + track.getName());
					// Song searchedSong = new Song(track, );
					// System.out.println("Name: " + searcedSong.getName());
	
				} else if (option == 2) {
					System.out.println("Searching for an album...");
				} else if (option == 3) {
					System.out.println("Searching for an artist...");
				} else if (option == 4) {
					System.out.println("Exiting...");
					break;
				} else {
					System.out.println("Invalid option. Please try again.");
				}
				System.out.println(" ");
			}
		} finally {
			scanner.close();
		}
	}

}
