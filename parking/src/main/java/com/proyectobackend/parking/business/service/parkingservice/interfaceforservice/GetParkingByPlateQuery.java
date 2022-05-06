package com.proyectobackend.parking.business.service.parkingservice.interfaceforservice;

import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;

public interface GetParkingByPlateQuery {
    ParkingResponse getParkingByPlate(String plate);
}
