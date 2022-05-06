package com.proyectobackend.parking.business.mapper.responseMapper;

import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.persistence.entity.Parking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParkingResponseMapper {

    ParkingResponse ParkingToParkingResponse(Parking parking);

}
