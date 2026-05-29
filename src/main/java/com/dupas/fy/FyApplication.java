package com.dupas.fy;

import java.util.Scanner;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.hc.core5.http.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import se.michaelthelin.spotify.requests.data.browse.GetRecommendationsRequest;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Recommendations;

import com.dupas.fy.util.SpotifyService;
import com.dupas.fy.util.PlaylistHandler;
import com.dupas.fy.util.Screen;
import com.dupas.fy.util.Song;
import com.dupas.fy.util.User;
import com.dupas.fy.util.CustomExceptions;

@SpringBootApplication
public class FyApplication {
	public static void main(String[] args) {

		SpringApplication.run(FyApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		User user = new User();
		Screen screen = new Screen();
		CustomExceptions CustomExceptions = new CustomExceptions();
		List<Object> spotifyTemporaryList = new ArrayList<>();

		try {
			user.isAuthServerOn();
			while (true) {
				if (user.isAuthenticated()) {
					user.checkLogin();
					user.requestAccessToken();
				}
				screen.showOptions();
				
				int option = scanner.nextInt();
				scanner.nextLine(); // consume the newline
				SpotifyService service = new SpotifyService();
					
				if (option == 1) {
					System.out.println("Give the id of a song: "); // ex: 5sxyNRAlsVwxOOQrXgs5kF
					String id_option = scanner.nextLine();
					System.out.println("Searching for a song...");
					CustomExceptions.checkIdException(id_option);
					var track = service.getTrack(id_option);
					Song searched_song = new Song(track);
					screen.showInfo(searched_song);
					spotifyTemporaryList.add(searched_song);

					PlaylistHandler ph = new PlaylistHandler();
			        ph.delete_song(user, searched_song, "6If8wvrOcP4MjXuZgSzsDE");

	
				} else if (option == 2) {
					System.out.println("Give the id of a album: "); // ex: 3gkyeCSebEhT149pgwiJB8
					String id_option = scanner.nextLine();
					System.out.println("Searching for a album...");
					CustomExceptions.checkIdException(id_option);
					var album = service.getAlbum(id_option);
					screen.showInfo(album);
					spotifyTemporaryList.add(album);

				} else if (option == 3) {
					System.out.println("Give the id of a artist: "); // ex: 3fMbdgg4jU18AjLCKBhRSm
					String id_option = scanner.nextLine();
					System.out.println("Searching for a artist...");
					CustomExceptions.checkIdException(id_option);
					var artist = service.getArtist(id_option);
					screen.showInfo(artist);
					spotifyTemporaryList.add(artist);

				} else if (option == 4) {
					System.out.println("Give the id of a playlist: "); // ex: 6p21dRudS9FmcyGvKWPq2R
					String id_option = scanner.nextLine();
					System.out.println("Searching for a playlist...");
					CustomExceptions.checkIdException(id_option);
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
					System.out.println("Give the id of a track: "); // ex: 01iyCAUm8EvOFqVWYJ3dVX
					String id_option = scanner.nextLine();
					System.out.println("Searching for a song...");
					CustomExceptions.checkIdException(id_option);
					var track = service.getTrack(id_option);

					System.out.println("Writing csv...");
					user.writePlaylistCSV(track);

					// System.out.println(service.getApi().getAccessToken());

					// GetRecommendationsRequest track = service.getApi().getRecommendations()
					// 	.limit(10)
					// 	.seed_tracks(id_option)
					// 	.build();
					// try {
					// 	Recommendations recommendations = track.execute();
					// 	System.out.println(recommendations.getTracks().length);
					// } catch (IOException | ParseException | SpotifyWebApiException e) {
			        //     throw new RuntimeException(e);
					// }
					
					// Song searched_song = new Song(track);
					// screen.showInfo(track);
				} else if (option == 7) {
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
