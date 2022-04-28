package com.proyectobackend.parking.presentation.controller.resquest.exception;

public class RoleNotFoundException extends RuntimeException{
    public RoleNotFoundException(String role){
        super("Role " + role + " not found");
    }
}
