package com.dupas.fy;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dupas.fy.SpotifyService;
// import com.dupas.fy.Song;
import com.dupas.fy.User;
import com.dupas.fy.Screen;


@SpringBootApplication
public class FyApplication {
	public static void main(String[] args) {

		SpringApplication.run(FyApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		Screen screen = new Screen();
		
		try {
			while (true) {
				screen.showOptions();
				
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
					screen.showInfo(searched_song);
	
				} else if (option == 2) {
					System.out.println("Give the id of a album: ");
					String id_option = scanner.nextLine();
					System.out.println("Searching for a album...");
					var album = service.getAlbum(id_option);
					screen.showInfo(album);

				} else if (option == 3) {
					System.out.println("Give the id of a artist: ");
					String id_option = scanner.nextLine();
					System.out.println("Searching for a artist...");
					var artist = service.getArtist(id_option);
					screen.showInfo(artist);

				} else if (option == 4) {
					System.out.println("Give the id of a playlist: ");
					String id_option = scanner.nextLine();
					System.out.println("Searching for a playlist...");
					var playlist = service.getPlaylist(id_option);
					screen.showInfo(playlist);

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
