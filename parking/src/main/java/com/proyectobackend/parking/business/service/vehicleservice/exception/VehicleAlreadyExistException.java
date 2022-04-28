package com.proyectobackend.parking.business.service.vehicleservice.exception;

public class VehicleAlreadyExistException  extends  RuntimeException{
    public VehicleAlreadyExistException(String plate){
        super("Vehicle plate " + plate + " already exist");
    }
}

