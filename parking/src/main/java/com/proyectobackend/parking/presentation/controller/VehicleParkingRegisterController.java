package com.proyectobackend.parking.presentation.controller;

import com.proyectobackend.parking.business.mapper.responseMapper.VehicleParkingResponseMapper;
import com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice.VehicleParkingMongoCrudService;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleParkingRegisterController {
    @Autowired
    private VehicleParkingMongoCrudService vehicleParkingMongoCrudService;

    @Autowired
    private VehicleParkingResponseMapper vehicleParkingResponseMapper;

    @GetMapping("parking/vehicleParkingRegister/all")
    public List<VehicleParkingResponse> getAllVehicleParkingRegister() {
        return vehicleParkingMongoCrudService.findAll();
    }

    @GetMapping("parking/vehicleParkingRegister/plate/{plate}")
    public List<VehicleParkingResponse> getVehicleParkingRegisterByPlate(@PathVariable String plate) {
        return vehicleParkingMongoCrudService.findVehicleParkingByPlate(plate);
    }

    @GetMapping("parking/vehicleParkingRegister/id/{id}")
    public VehicleParkingResponse getVehicleParkingRegisterByVehicleId(@PathVariable Long id) {
        return vehicleParkingMongoCrudService.findVehicleParkingById(id);
    }

    @DeleteMapping("parking/vehicleParkingRegister/id/{id}")
    public void deleteVehicleParkingRegisterByVehicleId(@PathVariable Long id) {
        vehicleParkingMongoCrudService.deleteVehicleParking(id);
    }
}
