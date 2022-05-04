package com.proyectobackend.parking.business.service.vehicleparkingservice;

import com.proyectobackend.parking.business.mapper.responseMapper.VehicleParkingMongoDbMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleParkingResponseMapper;
import com.proyectobackend.parking.business.service.vehicleparkingservice.exception.VehicleParkingNotFoundException;
import com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice.VehicleParkingMongoCrudService;
import com.proyectobackend.parking.persistence.entity.VehicleParking;
import com.proyectobackend.parking.persistence.entity.VehicleParkingMongoDb;
import com.proyectobackend.parking.persistence.repository.mongorepository.VehicleParkingMongoRepository;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleParkingMongoCrudServiceImpl implements VehicleParkingMongoCrudService {

    @Autowired
    VehicleParkingMongoRepository vehicleParkingMongoRepository;

    @Autowired
    VehicleParkingMongoDbMapper vehicleParkingMongoDbMapper;

    @Autowired
    VehicleParkingResponseMapper vehicleParkingResponseMapper;

    @Override
    public void saveVehicleParking(VehicleParkingResponse vehicleParking) {
        VehicleParkingMongoDb vehicleParkingMongoDb = vehicleParkingMongoDbMapper
                .entityToDocumentMongoDb(vehicleParkingResponseMapper.vehicleParkingResponseToVehicleParking(vehicleParking));
        vehicleParkingMongoRepository.save(vehicleParkingMongoDb);
    }

    @Override
    public void deleteVehicleParking(Long id) {
        vehicleParkingMongoRepository.deleteById(id);
    }

    @Override
    public VehicleParkingResponse findVehicleParkingById(Long id) {
        return vehicleParkingMongoDbMapper.documentToResponse(vehicleParkingMongoRepository.findById(id).orElseThrow(()-> new VehicleParkingNotFoundException(id)));
    }

    @Override
    public List<VehicleParkingResponse> findVehicleParkingByPlate(String plate) {
        return vehicleParkingMongoRepository.findByPlate(plate).stream().map(vehicleParkingMongoDbMapper::documentToResponse).collect(Collectors.toList());
    }

    @Override
    public List<VehicleParkingResponse> findAll() {
        return vehicleParkingMongoRepository.findAll().stream().map(vehicleParkingMongoDbMapper::documentToResponse).collect(Collectors.toList());
    }


}
