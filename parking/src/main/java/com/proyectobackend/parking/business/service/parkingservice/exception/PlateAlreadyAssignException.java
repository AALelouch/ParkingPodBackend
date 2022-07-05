package com.proyectobackend.parking.business.service.parkingservice.exception;

public class PlateAlreadyAssignException extends RuntimeException{
    public PlateAlreadyAssignException(String plate){
        super("Vehicle with plate: " + plate + " is already assign to other parking");
    }
}
