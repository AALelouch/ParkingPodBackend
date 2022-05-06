package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.business.mapper.requestMapper.ParkingRequestMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleResponseMapper;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetParkingAvailableQueryImpl implements com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.GetParkingAvailableQuery {

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingResponseMapper parkingMapperResponse;

    @Autowired
    VehicleResponseMapper vehicleMapperResponse;

    public List<ParkingResponse> getParkingAvailable() {
        List<Parking> parkingList = parkingRepository.findAllAvailable();
        List<ParkingResponse> parkingResponseList = new ArrayList<>();
        parkingList.forEach(parking ->{
            ParkingResponse parkingResponse = parkingMapperResponse.ParkingToParkingResponse(parking);
            if (parking.getPlate() != null) {
                parkingResponse.setVehicleResponse(vehicleRepository.findByPlate(parking.getPlate()).map(vehicleMapperResponse::vehicleToVehicleResponse).orElseThrow(() -> new VehicleNotFoundException("Vehicle not found")));
            }
            parkingResponseList.add(parkingResponse);
        });
        return parkingResponseList;
    }
}
