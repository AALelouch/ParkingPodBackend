package com.proyectobackend.parking.business.service.parkingservice.interfaceforservice;

import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;

public interface UnassignVehicleToParkingCommand {
    ParkingResponse unassignVehicleToParking(String plate);
}
