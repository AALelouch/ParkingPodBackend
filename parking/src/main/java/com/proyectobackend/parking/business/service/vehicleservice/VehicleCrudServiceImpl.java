package com.proyectobackend.parking.business.service.vehicleservice;

import com.proyectobackend.parking.presentation.controller.resquest.VehicleRequest;
import com.proyectobackend.parking.presentation.controller.response.VehicleResponse;
import com.proyectobackend.parking.business.mapper.requestMapper.VehicleRequestMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleResponseMapper;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleAlreadyExistException;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import com.proyectobackend.parking.persistence.entity.Vehicle;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleCrudServiceImpl implements com.proyectobackend.parking.business.service.vehicleservice.interfaceforservice.VehicleCrudService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    VehicleResponseMapper vehicleResponseMapper;

    @Autowired
    VehicleRequestMapper vehicleRequestMapper;

    public List<VehicleResponse> getVehicles() {
        return vehicleRepository.findAll().stream().map(vehicleResponseMapper::vehicleToVehicleResponse).collect(Collectors.toList());
    }

    public VehicleResponse getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new VehicleNotFoundException(id));
        return vehicleResponseMapper.vehicleToVehicleResponse(vehicle);
    }

    public void createVehicle(VehicleRequest vehicleRequest) {
        Vehicle vehicleEntity = vehicleRequestMapper.vehicleRequestToVehicle(vehicleRequest);
        if (vehicleRepository.findAll().contains(vehicleEntity)){
            throw  new VehicleAlreadyExistException(vehicleRequest.getPlate());
        }
        Vehicle vehicleToSave = vehicleRepository.save(vehicleEntity);
    }

    public void updateVehicle(VehicleRequest vehicleRequest, Long id) {
        Vehicle vehicleEntity = vehicleRequestMapper.vehicleRequestToVehicle(vehicleRequest);
        Vehicle vehicleToUpdate = vehicleRepository.findById(id).map(vehicleMap -> {
            vehicleMap.setPlate(vehicleEntity.getPlate());
            vehicleMap.setColor(vehicleEntity.getColor());
            vehicleMap.setType(vehicleEntity.getType());
            return vehicleRepository.save(vehicleMap);
        }).orElseGet(() -> {
            vehicleEntity.setId(id);
            return vehicleRepository.save(vehicleEntity);
        });
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
