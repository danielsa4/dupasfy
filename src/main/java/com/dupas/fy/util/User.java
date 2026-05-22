package com.dupas.fy.util;

import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import se.michaelthelin.spotify.model_objects.specification.Track;
import org.springframework.web.client.RestClient;
import com.dupas.fy.dto.TokenResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String account;
    private Song[] history;
    private final RestClient restClient;
    private boolean isAuthenticated;
    private String access_token;
  
    public User(){
        this.restClient = RestClient.create();
    }

    public User(String new_account){
		this.account = new_account;
        this.restClient = RestClient.create();
	}

    public void isAuthServerOn() {
        try (Socket socket = new Socket("localhost", 8080)) {
            this.isAuthenticated = true;
        } catch (IOException e) {
            this.isAuthenticated = false; 
        }
    }

    public void checkLogin() {
        System.out.println("Checking the login information...");

        boolean response = restClient.get()
            .uri("http://127.0.0.1:3000/auth/get-is-logged")
            .retrieve()
            .body(Boolean.class);
        if (response) {
            System.out.println("You're already logged!");
        } else {
            System.out.println("You're not logged yet. Clink on the link to authenticate: http://127.0.0.1:8080/");
        }
    }

    public void requestAccessToken() {
        TokenResponse token_response = restClient.get()
            .uri("http://127.0.0.1:3000/auth/get-token")
            .retrieve()
            .body(TokenResponse.class);
        this.access_token = token_response.getAccess_token();
    }

    public void writePlaylistCSV(Track t) {
        try {
            Path outputDir = Paths.get("output");
            Path filePath = outputDir.resolve("playlist.csv");

            // Cria a pasta se não existir
            Files.createDirectories(outputDir);

            // Define o cabeçalho do CSV
            String header = "filepath,artist,album,title,length,tracktype,state,failurereason\n";

            // Se o arquivo não existe, cria e adiciona o cabeçalho
            if (!Files.exists(filePath)) {
                Files.write(filePath, header.getBytes(), StandardOpenOption.CREATE_NEW);
            }

            // Extrai informações do Track
            String filepath = "";
            String artist = t.getArtists().length > 0 ? t.getArtists()[0].getName() : "";
            String album = t.getAlbum() != null ? t.getAlbum().getName() : "";
            String title = t.getName();
            long durationMs = t.getDurationMs();
            long length = durationMs / 1000; // Converte de milissegundos para segundos
            int tracktype = 0;
            int state = 2;
            int failurereason = 3;

            // Cria a linha a ser adicionada
            String csvLine = String.format(
                "%s,%s,%s,%s,%d,%d,%d,%d\n",
                filepath, artist, album, title, length, tracktype, state, failurereason
            );

            // Adiciona a linha ao arquivo
            Files.write(filePath, csvLine.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            System.out.println("Track adicionado ao CSV com sucesso: " + title);

        } catch (IOException e) {
            System.err.println("Erro ao escrever o track no CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
