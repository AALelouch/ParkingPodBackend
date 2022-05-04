package com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice;

import com.proyectobackend.parking.persistence.entity.VehicleParking;
import com.proyectobackend.parking.persistence.entity.VehicleParkingMongoDb;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;

import java.util.List;

public interface VehicleParkingMongoCrudService {
    void saveVehicleParking(VehicleParkingResponse vehicleParking);

    void deleteVehicleParking(Long id);

    VehicleParkingResponse findVehicleParkingById(Long id);

    List<VehicleParkingResponse> findVehicleParkingByPlate(String plate);

    List<VehicleParkingResponse> findAll();

}
