package com.proyectobackend.parking.business.service.vehicleservice.interfaceforservice;

import com.proyectobackend.parking.presentation.controller.resquest.VehicleRequest;
import com.proyectobackend.parking.presentation.controller.response.VehicleResponse;

import java.util.List;

public interface VehicleCrudService {

    List<VehicleResponse> getVehicles();
    VehicleResponse getVehicleById(Long id);
    void createVehicle(VehicleRequest vehicle);
    void updateVehicle(VehicleRequest vehicle, Long id);
    void deleteVehicle(Long id);
}
