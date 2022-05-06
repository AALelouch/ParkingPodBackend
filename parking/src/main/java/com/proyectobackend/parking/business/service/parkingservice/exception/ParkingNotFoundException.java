package com.proyectobackend.parking.business.service.parkingservice.exception;

import com.proyectobackend.parking.persistence.entity.Parking;

public class ParkingNotFoundException extends RuntimeException {
    public ParkingNotFoundException(Long id){
        super("Could not find the parking with id: " + id);
    }
    public ParkingNotFoundException(String plate){super("Could not find the parking assign to plate: " + plate);}
    public ParkingNotFoundException(){super("Parking without vehicle");}
}
