package com.proyectobackend.parking.business.service.parkingservice.exception;

public class ParkingNotFoundException extends RuntimeException {
    public ParkingNotFoundException(Long id){
        super("Could not find the parking with id: " + id);
    }
}
