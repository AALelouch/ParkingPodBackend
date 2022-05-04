package com.proyectobackend.parking.presentation.controller.resquest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String username;
    private String password;
    private String role;
}
