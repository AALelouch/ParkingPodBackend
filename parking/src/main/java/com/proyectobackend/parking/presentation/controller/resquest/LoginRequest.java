package com.proyectobackend.parking.presentation.controller.resquest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;
}
