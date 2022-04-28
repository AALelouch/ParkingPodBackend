package com.proyectobackend.parking.business.service.vehicleservice;

import com.proyectobackend.parking.presentation.controller.response.VehicleResponse;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleResponseMapper;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import com.proyectobackend.parking.persistence.entity.Vehicle;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetByPlateOfVehicleQueryImpl implements com.proyectobackend.parking.business.service.vehicleservice.interfaceforservice.GetByPlateOfVehicleQuery {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleResponseMapper vehicleMapper;

    @Override
    public VehicleResponse getVehicleByPlate(String plate) {
        Vehicle vehicle = vehicleRepository.findByPlate(plate);
        if (vehicle == null) {
            throw new VehicleNotFoundException(plate);
        }
        return vehicleMapper.vehicleToVehicleResponse(vehicle);
    }
}
