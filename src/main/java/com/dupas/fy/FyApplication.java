package com.dupas.fy;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dupas.fy.SpotifyService;
import com.dupas.fy.User;
import com.dupas.fy.Screen;


@SpringBootApplication
public class FyApplication {
	public static void main(String[] args) {

		SpringApplication.run(FyApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		Screen screen = new Screen();
		List<Object> spotifyTemporaryList = new ArrayList<>();
		
		try {
			while (true) {
				screen.showOptions();
				
				int option = scanner.nextInt();
				scanner.nextLine(); // consume the newline
				SpotifyService service = new SpotifyService();
					
				if (option == 1) {
					System.out.println("Give the id of a song: "); // ex: 5sxyNRAlsVwxOOQrXgs5kF
					String id_option = scanner.nextLine();
					System.out.println("Searching for a song...");
					var track = service.getTrack(id_option);
					Song searched_song = new Song(track);
					screen.showInfo(searched_song);
					spotifyTemporaryList.add(searched_song);
	
				} else if (option == 2) {
					System.out.println("Give the id of a album: "); // ex: 3gkyeCSebEhT149pgwiJB8
					String id_option = scanner.nextLine();
					System.out.println("Searching for a album...");
					var album = service.getAlbum(id_option);
					screen.showInfo(album);
					spotifyTemporaryList.add(album);

				} else if (option == 3) {
					System.out.println("Give the id of a artist: "); // ex: 3fMbdgg4jU18AjLCKBhRSm
					String id_option = scanner.nextLine();
					System.out.println("Searching for a artist...");
					var artist = service.getArtist(id_option);
					screen.showInfo(artist);
					spotifyTemporaryList.add(artist);

				} else if (option == 4) {
					System.out.println("Give the id of a playlist: "); // ex: 6p21dRudS9FmcyGvKWPq2R
					String id_option = scanner.nextLine();
					System.out.println("Searching for a playlist...");
					var playlist = service.getPlaylist(id_option);
					screen.showInfo(playlist);
					spotifyTemporaryList.add(playlist);

					// var a = service.getPlaylistItems(id_option);
					// test
					// System.out.print("Write your account name: ");
					// String account_name = scanner.nextLine();
					// User user = new User(account_name);
					// user.writePlaylistCSV(playlist);

				} else if (option == 5) {
					System.out.println("Your searched items: ");
					spotifyTemporaryList.forEach((item) -> {
						screen.showInfo(item);
						System.out.println(" ");
					});
				} else if (option == 6) {
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
