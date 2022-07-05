package com.proyectobackend.parking.business.service.parkingservice.interfaceforservice;

import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;

import java.util.List;

public interface GetByPlateRecordQuery {
    List<ParkingResponse> getByPlateRecords(String plate);
}
