package com.proyectobackend.parking.business.mapper;

import com.proyectobackend.parking.business.service.parkingservice.messageservice.ParkingMessage;
import com.proyectobackend.parking.business.service.parkingservice.messageservice.VehicleMessage;
import com.proyectobackend.parking.persistence.entity.ParkingForMongoDb;
import com.proyectobackend.parking.persistence.entity.VehicleForMongoDb;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParkingMessageMapper {

    @Mapping(source = "parkingForMongoDb.vehicleForMongoDb", target = "vehicleMessage")
    ParkingMessage toParkingMessage(ParkingForMongoDb parkingForMongoDb);
    VehicleMessage toVehicleMessage(VehicleForMongoDb vehicleResponse);
}
