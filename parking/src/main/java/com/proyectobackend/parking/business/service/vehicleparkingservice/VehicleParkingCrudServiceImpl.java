package com.proyectobackend.parking.business.service.vehicleparkingservice;

import com.proyectobackend.parking.business.mapper.requestMapper.VehicleParkingRequestMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleParkingResponseMapper;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.VehicleParkingRequest;
import com.proyectobackend.parking.business.service.parkingservice.exception.ParkingNotFoundException;
import com.proyectobackend.parking.business.service.vehicleparkingservice.exception.VehicleParkingNotFoundException;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.entity.VehicleParking;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import com.proyectobackend.parking.persistence.repository.VehicleParkingRepository;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleParkingCrudServiceImpl implements com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice.VehicleParkingCrudService {

    @Autowired
    VehicleParkingRepository vehicleParkingRepository;
    @Autowired
    VehicleParkingResponseMapper vehicleParkingResponseMapper;
    @Autowired
    VehicleParkingRequestMapper vehicleParkingRequestMapper;
    @Autowired
    ParkingRepository parkingRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<VehicleParkingResponse> findAll() {
        return vehicleParkingRepository.findAll().stream().map(vehicleParkingResponseMapper::vehicleParkingToVehicleParkingResponse).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public ResponseEntity<VehicleParkingResponse> findById(Long id) {
        VehicleParking vehicleParkingEntity = vehicleParkingRepository.findById(id).orElseThrow((() -> new VehicleParkingNotFoundException(id)));

        return ResponseEntity.ok(vehicleParkingResponseMapper.vehicleParkingToVehicleParkingResponse(vehicleParkingEntity));
    }

    @Override
    public void save(VehicleParkingRequest vehicleParkingDto) {
        VehicleParking vehicleParkingEntity = vehicleParkingRequestMapper.vehicleParkingRequestToVehicleParking(vehicleParkingDto);

        vehicleParkingEntity.setParking(parkingRepository.findById(vehicleParkingDto.getParking().getIdSlot()).orElseThrow(() -> new ParkingNotFoundException(vehicleParkingDto.getParking().getIdSlot())));
        Parking parkingEntity = parkingRepository.findById(vehicleParkingDto.getParking().getIdSlot()).orElseThrow((() -> new ParkingNotFoundException(vehicleParkingDto.getParking().getIdSlot()) ));
        parkingEntity.setAvailable(false);
        parkingRepository.save(parkingEntity);

        vehicleParkingEntity.setVehicle(vehicleRepository.findById(vehicleParkingDto.getVehicle().getId()).orElseThrow(() -> new VehicleNotFoundException(vehicleParkingDto.getVehicle().getId())));

        vehicleParkingRepository.save(vehicleParkingEntity);
    }

    @Override
    public void update(VehicleParkingRequest vehicleParkingDto, Long id) {
        VehicleParking vehicleParkingEntity = vehicleParkingRequestMapper.vehicleParkingRequestToVehicleParking(vehicleParkingDto);

        vehicleParkingEntity.setParking(parkingRepository.findById(vehicleParkingDto.getParking().getIdSlot()).orElseThrow(() -> new ParkingNotFoundException(vehicleParkingDto.getParking().getIdSlot())));
        Parking parkingEntity = parkingRepository.findById(vehicleParkingDto.getParking().getIdSlot()).orElseThrow((() -> new ParkingNotFoundException(vehicleParkingDto.getParking().getIdSlot()) ));
        parkingEntity.setAvailable(false);
        parkingRepository.save(parkingEntity);

        vehicleParkingEntity.setVehicle(vehicleRepository.findById(vehicleParkingDto.getVehicle().getId()).orElseThrow(() -> new VehicleNotFoundException(vehicleParkingDto.getVehicle().getId())));

        vehicleParkingEntity.setIdCheck(id);

        vehicleParkingRepository.save(vehicleParkingEntity);

    }

    @Override
    public void delete(Long id) {

        vehicleParkingRepository.deleteById(id);
        VehicleParking vehicleParking =vehicleParkingRepository.findById(id).orElseThrow(() -> new VehicleParkingNotFoundException(id));

        Parking parkingEntity = parkingRepository.findById(vehicleParking.getParking().getIdSlot()).orElseThrow(() -> new ParkingNotFoundException(vehicleParking.getParking().getIdSlot()));
        parkingEntity.setAvailable(true);
        parkingRepository.save(parkingEntity);
    }
}
