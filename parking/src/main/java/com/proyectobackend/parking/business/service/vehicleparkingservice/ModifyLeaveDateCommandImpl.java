package com.proyectobackend.parking.business.service.vehicleparkingservice;

import com.proyectobackend.parking.business.mapper.responseMapper.VehicleParkingResponseMapper;
import com.proyectobackend.parking.business.service.vehicleparkingservice.exception.VehicleParkingNotFoundException;
import com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice.ModifyLeaveDateCommand;
import com.proyectobackend.parking.persistence.entity.VehicleParking;
import com.proyectobackend.parking.persistence.repository.VehicleParkingRepository;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ModifyLeaveDateCommandImpl implements ModifyLeaveDateCommand {

    @Autowired
    VehicleParkingRepository vehicleParkingRepository;

    @Autowired
    VehicleParkingResponseMapper vehicleParkingMapper;


    @Override
    public ResponseEntity<VehicleParkingResponse> modifyLeaveDate(Long id, LocalDateTime leaveDate) {
        VehicleParking vehicleParkingEntity = vehicleParkingRepository.findById(id).orElseThrow(() -> new VehicleParkingNotFoundException(id));
        vehicleParkingEntity.setLeaveDate(leaveDate);
        vehicleParkingRepository.save(vehicleParkingEntity);
        return ResponseEntity.ok(vehicleParkingMapper.vehicleParkingToVehicleParkingResponse(vehicleParkingEntity));
    }
}
