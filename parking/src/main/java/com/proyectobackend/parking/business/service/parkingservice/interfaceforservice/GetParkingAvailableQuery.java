package com.proyectobackend.parking.business.service.parkingservice.interfaceforservice;

import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;

import java.util.List;

public interface GetParkingAvailableQuery {
    List<ParkingResponse> getParkingAvailable();

}
