package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleResponseMapper;
import com.proyectobackend.parking.business.service.parkingservice.exception.ParkingNotFoundException;
import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.GetParkingByPlateQuery;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetParkingByPlateQueryImpl implements GetParkingByPlateQuery {
    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingResponseMapper parkingMapperResponse;

    @Autowired
    VehicleResponseMapper vehicleMapperResponse;

    @Override
    public ParkingResponse getParkingByPlate(String plate) {
        Parking parking = parkingRepository.findByPlate(plate).orElseThrow(() -> new ParkingNotFoundException(plate));
        ParkingResponse parkingResponse = parkingMapperResponse.ParkingToParkingResponse(parking);
        parkingResponse.setVehicleResponse(vehicleMapperResponse.vehicleToVehicleResponse(vehicleRepository.findByPlate(plate).orElseThrow(() -> new VehicleNotFoundException(plate))));
        return parkingResponse;
    }
}
