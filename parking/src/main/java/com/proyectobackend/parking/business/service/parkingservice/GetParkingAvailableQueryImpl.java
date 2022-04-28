package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetParkingAvailableQueryImpl implements com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.GetParkingAvailableQuery {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private ParkingResponseMapper parkingMapper;

    public List<ParkingResponse> getParkingAvailable() {
        return parkingRepository.findAllAvailable().stream().map(parkingMapper::ParkingToParkingForEntityResponse).collect(Collectors.toList());
    }
}
