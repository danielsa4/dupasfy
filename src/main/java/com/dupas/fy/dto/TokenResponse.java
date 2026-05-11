package com.dupas.fy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {
    private String access_token;
    private String refresh_token;
}