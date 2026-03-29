package com.dupas.fy;

import io.github.cdimascio.dotenv.Dotenv;


public class SpotifyExample {

    public static void main(String[] args) {

        SpotifyService service = new SpotifyService();

        String trackId = "3n3Ppam7vgaVa1iaRUc9Lp";
        try {
            var track = service.getTrack(trackId);

            System.out.println("Nome: " + track.getName());
            System.out.println("Artista: " + track.getArtists()[0].getName());

        }

        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
