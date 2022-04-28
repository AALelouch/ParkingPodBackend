package com.proyectobackend.parking.business.mapper.responseMapper;

import com.proyectobackend.parking.presentation.controller.response.VehicleResponse;
import com.proyectobackend.parking.persistence.entity.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleResponseMapper {
    VehicleResponse vehicleToVehicleResponse(Vehicle vehicle);
    Vehicle vehicleResponseToVehicle(VehicleResponse vehicleResponse);
}
