package com.proyectobackend.parking.business.service.parkingservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyectobackend.parking.business.mapper.requestMapper.ParkingRequestMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleResponseMapper;
import com.proyectobackend.parking.business.service.parkingservice.exception.ParkingNotFoundException;
import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.ModifyLeaveDateCommand;
import com.proyectobackend.parking.business.service.parkingservice.util.CalculateHour;
import com.proyectobackend.parking.business.service.parkingservice.util.CalculatePrice;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ModifyLeaveDateCommandImpl implements ModifyLeaveDateCommand {
    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingRequestMapper parkingMapperRequest;

    @Autowired
    ParkingResponseMapper parkingMapperResponse;

    @Autowired
    VehicleResponseMapper vehicleMapperResponse;

    @Override
    public ResponseEntity<ParkingResponse> modifyLeaveDate(Long id,     @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime leaveDate) {
        Parking parking = parkingRepository.findById(id).orElseThrow(()-> new ParkingNotFoundException(id));
        if (parking.getPlate() == null) {
            throw new ParkingNotFoundException();
        }
        parking.setLeaveDate(leaveDate);
        parking.setHours(CalculateHour.calculateHour(parking.getEntryDate(), parking.getLeaveDate()));
        parking.setTotalPrice(CalculatePrice.calculatePrice(parking.getHours(), parking.getPriceHour(), parking.getPriceDay()));
        parkingRepository.save(parking);

        ParkingResponse responseParking = parkingMapperResponse.ParkingToParkingResponse(parking);
        responseParking.setVehicleResponse(vehicleMapperResponse.vehicleToVehicleResponse(vehicleRepository.findByPlate(parking.getPlate()).orElseThrow(() ->new VehicleNotFoundException(parking.getPlate()))));

        return ResponseEntity.ok(responseParking);
    }
}
