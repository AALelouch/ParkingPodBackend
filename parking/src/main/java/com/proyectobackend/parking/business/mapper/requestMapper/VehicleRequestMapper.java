package com.proyectobackend.parking.business.mapper.requestMapper;

import com.proyectobackend.parking.presentation.controller.resquest.VehicleRequest;
import com.proyectobackend.parking.persistence.entity.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleRequestMapper {
    VehicleRequest vehicleToVehicleRequest(Vehicle vehicleRequest);
    Vehicle vehicleRequestToVehicle(VehicleRequest vehicleRequest);
}
