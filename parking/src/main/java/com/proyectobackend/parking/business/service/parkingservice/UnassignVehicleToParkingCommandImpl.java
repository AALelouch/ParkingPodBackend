package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.business.mapper.ParkingDocumentResponseMapper;
import com.proyectobackend.parking.business.mapper.ParkingMessageMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleResponseMapper;
import com.proyectobackend.parking.business.service.parkingservice.messageservice.ParkingMessage;
import com.proyectobackend.parking.business.service.parkingservice.messageservice.RabbitMqSender;
import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.UnassignVehicleToParkingCommand;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.entity.ParkingForMongoDb;
import com.proyectobackend.parking.persistence.repository.ParkingMongoRepository;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnassignVehicleToParkingCommandImpl implements UnassignVehicleToParkingCommand {

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    ParkingDocumentResponseMapper parkingForMongoDbMapper;

    @Autowired
    ParkingMongoRepository parkingForMongoRepository;

    @Autowired
    ParkingResponseMapper parkingResponseMapper;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleResponseMapper vehicleResponseMapper;

    @Autowired
    RabbitMqSender rabbitMqSender;

    @Autowired
    ParkingMessageMapper parkingMessageMapper;

    @Override
    public ParkingResponse unassignVehicleToParking(String plate) {
        if(parkingRepository.findByPlate(plate).isEmpty()){
            throw new VehicleNotFoundException(plate);
        }

        Parking parking = parkingRepository.findByPlate(plate).orElseThrow(()-> new VehicleNotFoundException(plate) );
        ParkingResponse parkingResponse = parkingResponseMapper.ParkingToParkingResponse(parking);
        parkingResponse.setVehicleResponse(vehicleRepository.findByPlate(parking.getPlate()).map(vehicleResponseMapper::vehicleToVehicleResponse).orElseThrow(() -> new VehicleNotFoundException(parking.getPlate())));
        ParkingForMongoDb parkingForMongoDb =parkingForMongoDbMapper.toParkingForMongoDb(parkingResponse);
        parkingForMongoRepository.save(parkingForMongoDb);

        ParkingMessage parkingMessage = parkingMessageMapper.toParkingMessage(parkingForMongoDb);
        rabbitMqSender.send(parkingMessage);

        parking.setPlate(null);
        parking.setEntryDate(null);
        parking.setLeaveDate(null);
        parking.setHours(null);
        parking.setTotalPrice(0.0);
        parking.setAvailable(true);
        parkingRepository.save(parking);

        return parkingResponseMapper.ParkingToParkingResponse(parking);
    }
}
