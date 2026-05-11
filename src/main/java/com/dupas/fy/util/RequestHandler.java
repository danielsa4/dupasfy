package com.dupas.fy.util;

import java.io.IOException;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.requests.IRequest;


public class RequestHandler <T> {

    public T executeSpotifyRequest(IRequest<T> request) {
        try {
            return request.execute();
        } catch (IOException | ParseException | SpotifyWebApiException e) {
            throw new RuntimeException(e);
        }
    }

}
