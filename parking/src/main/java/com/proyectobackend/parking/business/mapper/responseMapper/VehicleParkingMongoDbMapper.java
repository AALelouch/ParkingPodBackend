package com.proyectobackend.parking.business.mapper.responseMapper;

import com.proyectobackend.parking.persistence.entity.VehicleParking;
import com.proyectobackend.parking.persistence.entity.VehicleParkingMongoDb;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleParkingMongoDbMapper {

    VehicleParkingMongoDb entityToDocumentMongoDb(VehicleParking vehicleParking);
    VehicleParkingResponse documentToResponse(VehicleParkingMongoDb vehicleParking);
}
