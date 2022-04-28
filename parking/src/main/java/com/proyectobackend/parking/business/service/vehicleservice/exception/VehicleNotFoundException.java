package com.proyectobackend.parking.business.service.vehicleservice.exception;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(Long id) {
        super("Vehicle id " + id + " not found");
    }

    public VehicleNotFoundException(String plate) {
        super("Vehicle plate " + plate + " not found");
    }
}
