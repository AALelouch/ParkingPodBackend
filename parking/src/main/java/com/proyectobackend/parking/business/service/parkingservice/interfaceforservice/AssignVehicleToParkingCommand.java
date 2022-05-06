package com.proyectobackend.parking.business.service.parkingservice.interfaceforservice;

import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.AssignRequest;

import java.time.LocalDateTime;

public interface AssignVehicleToParkingCommand {
    ParkingResponse assignVehicleToParking(AssignRequest assignRequest);
}
