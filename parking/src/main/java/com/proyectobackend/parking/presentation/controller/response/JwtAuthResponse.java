package com.proyectobackend.parking.presentation.controller.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtAuthResponse {
    private String token;
    private String type = "Bearer";

    public JwtAuthResponse(String accessToken) {
        this.token = accessToken;
    }
}
