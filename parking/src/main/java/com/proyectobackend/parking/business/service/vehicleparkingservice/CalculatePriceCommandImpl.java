package com.proyectobackend.parking.business.service.vehicleparkingservice;

import com.proyectobackend.parking.business.mapper.responseMapper.VehicleParkingResponseMapper;
import com.proyectobackend.parking.business.service.vehicleparkingservice.exception.VehicleParkingNotFoundException;
import com.proyectobackend.parking.business.service.vehicleparkingservice.util.CalculateHour;
import com.proyectobackend.parking.business.service.vehicleparkingservice.util.CalculatePrice;
import com.proyectobackend.parking.persistence.entity.VehicleParking;
import com.proyectobackend.parking.persistence.repository.VehicleParkingRepository;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatePriceCommandImpl implements com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice.CalculatePriceCommand {

    @Autowired
    VehicleParkingRepository vehicleParkingRepository;

    @Autowired
    VehicleParkingResponseMapper vehicleParkingMapper;

    @Override
    public ResponseEntity<VehicleParkingResponse> calculatePrice(Long id) {
        VehicleParking vehicleParkingEntity = vehicleParkingRepository.findById(id).orElseThrow(() -> new VehicleParkingNotFoundException(id));

        vehicleParkingEntity.setHours(CalculateHour.calculateHour(vehicleParkingEntity.getEntryDate(), vehicleParkingEntity.getLeaveDate()));
        vehicleParkingEntity.setPrice(CalculatePrice.calculatePrice(vehicleParkingEntity.getHours(), vehicleParkingEntity.getParking().getPriceHour(), vehicleParkingEntity.getParking().getPriceDay()));
        vehicleParkingRepository.save(vehicleParkingEntity);

        return ResponseEntity.ok(vehicleParkingMapper.vehicleParkingToVehicleParkingResponse(vehicleParkingEntity));
    }
}
