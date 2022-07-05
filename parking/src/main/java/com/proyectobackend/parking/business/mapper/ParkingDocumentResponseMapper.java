package com.proyectobackend.parking.business.mapper;

import com.proyectobackend.parking.persistence.entity.ParkingForMongoDb;
import com.proyectobackend.parking.persistence.entity.VehicleForMongoDb;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.presentation.controller.response.VehicleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParkingDocumentResponseMapper {

    @Mapping(source = "parking.vehicleResponse", target = "vehicleForMongoDb")
    ParkingForMongoDb toParkingForMongoDb(ParkingResponse parking);
    @Mapping(source = "parkingForMongoDb.vehicleForMongoDb", target = "vehicleResponse")
    ParkingResponse toParkingResponse(ParkingForMongoDb parkingForMongoDb);

    VehicleForMongoDb toVehicleForMongoDb(VehicleResponse parking);
    VehicleResponse toVehicleResponse(VehicleForMongoDb parkingForMongoDb);
}
