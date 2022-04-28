package com.proyectobackend.parking.business.service.vehicleparkingservice.exception;

public class VehicleParkingNotFoundException extends RuntimeException {
    public VehicleParkingNotFoundException(Long id) {
        super("VehicleParking with id " + id + " not found");
    }
}
