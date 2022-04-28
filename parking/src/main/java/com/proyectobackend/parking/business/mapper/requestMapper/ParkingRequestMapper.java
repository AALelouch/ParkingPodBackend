package com.proyectobackend.parking.business.mapper.requestMapper;

import com.proyectobackend.parking.presentation.controller.resquest.ParkingRequest;
import com.proyectobackend.parking.persistence.entity.Parking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParkingRequestMapper {

    ParkingRequest parkingToParkingForEntityRequest(Parking parking);
    Parking parkingForEntityRequestToParking(ParkingRequest parkingForEntityRequest);

}
