package com.dupas.fy;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dupas.fy.SpotifyService;
import com.dupas.fy.Song;
import com.dupas.fy.User;


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
				System.out.println("4. Search for an playlist");
				System.out.println("5. Exit");
				int option = scanner.nextInt();
				scanner.nextLine(); // consume the newline
				SpotifyService service = new SpotifyService();
					
				if (option == 1) {
					System.out.println("Give the id of a song: ");
					String id_option = scanner.nextLine();
					System.out.println("Searching for a song...");
					var track = service.getTrack(id_option);
					// var album = track.getAlbum();
					Song searched_song = new Song(track);
					System.out.println("Id: " + searched_song.getId());
					System.out.println("Name: " + searched_song.getName());
	
				} else if (option == 2) {
					System.out.println("Give the id of a album: ");
					String id_option = scanner.nextLine();
					System.out.println("Searching for a album...");
					var album = service.getAlbum(id_option);
					System.out.println("Id: " + album.getId());
					System.out.println("Name: " + album.getName());

				} else if (option == 3) {
					System.out.println("Give the id of a artist: ");
					String id_option = scanner.nextLine();
					System.out.println("Searching for a artist...");
					var artist = service.getArtist(id_option);
					System.out.println("Id: " + artist.getId());
					System.out.println("Name: " + artist.getName());

				} else if (option == 4) {
					System.out.println("Give the id of a playlist: ");
					String id_option = scanner.nextLine();
					System.out.println("Searching for a playlist...");
					var playlist = service.getPlaylist(id_option);
					System.out.println("Id: " + playlist.getId());
					System.out.println("Name: " + playlist.getName());

					// var a = service.getPlaylistItems(id_option);

					// test
					// System.out.print("Write your account name: ");
					// String account_name = scanner.nextLine();
					// User user = new User(account_name);
					// user.writePlaylistCSV(playlist);

				} else if (option == 5) {
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
