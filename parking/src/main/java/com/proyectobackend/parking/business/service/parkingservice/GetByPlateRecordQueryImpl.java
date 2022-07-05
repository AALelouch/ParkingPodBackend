package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.business.mapper.ParkingDocumentResponseMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.GetByPlateRecordQuery;
import com.proyectobackend.parking.persistence.repository.ParkingMongoRepository;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetByPlateRecordQueryImpl implements GetByPlateRecordQuery {

    @Autowired
    ParkingMongoRepository parkingMongoRepository;

    @Autowired
    ParkingResponseMapper parkingMapperResponse;

    @Autowired
    ParkingDocumentResponseMapper parkingDocumentResponseMapper;

    @Override
    public List<ParkingResponse> getByPlateRecords(String plate) {
        return parkingMongoRepository.findByPlate(plate).stream().map(parkingDocumentResponseMapper::toParkingResponse).collect(Collectors.toList());
    }
}
