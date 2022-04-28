package com.proyectobackend.parking.business.service.vehicleservice.interfaceforservice;

import com.proyectobackend.parking.presentation.controller.response.VehicleResponse;

public interface GetByPlateOfVehicleQuery {
    VehicleResponse getVehicleByPlate(String plate);
}
