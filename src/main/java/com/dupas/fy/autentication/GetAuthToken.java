package com.dupas.fy.autentication;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.hc.core5.http.ParseException;

import com.dupas.fy.SpotifyService;

public class GetAuthToken {

    public static AuthorizationCodeCredentials exchangeCodeForTokens(String authorizationCode) {
        SpotifyService service = new SpotifyService();
        SpotifyApi spotifyApi = new SpotifyApi.Builder()
                    .setClientId(service.getApi().getClientId())
                    .setClientSecret(service.getApi().getClientSecret())
                    .setRedirectUri(URI.create("http://127.0.0.1:8080/callback"))
                    .build();
        
        try {
            // Debug: imprime informações (remova em produção)
            System.out.println("Código recebido: " + 
                (authorizationCode.length() > 20 ? 
                    authorizationCode.substring(0, 20) + "..." : authorizationCode));
            System.out.println("🔗 Redirect URI configurado: " + URI.create("http://127.0.0.1:8080/callback"));
            
            // Garante que o código está limpo (sem espaços ou quebras)
            String cleanCode = authorizationCode.trim();
            
            AuthorizationCodeRequest request = spotifyApi.authorizationCode(cleanCode)
                    .build();
            
            System.out.println("Trocando código por tokens...");
            AuthorizationCodeCredentials credentials = request.execute();
            
            spotifyApi.setAccessToken(credentials.getAccessToken());
            spotifyApi.setRefreshToken(credentials.getRefreshToken());
            
            System.out.println("Tokens obtidos com sucesso!");
            System.out.println("Access Token (primeiros 30 chars): " + 
                credentials.getAccessToken().substring(0, 30) + "...");
            System.out.println("Refresh Token (primeiros 30 chars): " + 
                credentials.getRefreshToken().substring(0, 30) + "...");
            
            return credentials;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.err.println("Erro ao obter tokens: " + e.getMessage());
            
            // Debug adicional para BadRequestException
            if (e.getMessage().contains("Invalid authorization code")) {
                System.err.println("\n Possíveis causas:");
                System.err.println("   1. O código já foi usado (é single-use)");
                System.err.println("   2. O código expirou (>10 minutos)");
                System.err.println("   3. Redirect URI não bate com o da autorização");
                System.err.println("   4. Client ID/Secret incorretos");
                System.err.println("   5. Código copiado com espaços ou caracteres extras");
            }
            
            e.printStackTrace();
            throw new RuntimeException("Falha na troca do authorization code", e);
        }
    }
}