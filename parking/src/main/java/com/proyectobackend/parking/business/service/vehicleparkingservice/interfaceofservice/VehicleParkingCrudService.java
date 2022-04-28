package com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice;

import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.VehicleParkingRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleParkingCrudService {
    List<VehicleParkingResponse> findAll();
    ResponseEntity<VehicleParkingResponse> findById(Long id);
    void save(VehicleParkingRequest vehicleParkingDto);
    void update(VehicleParkingRequest vehicleParkingDto, Long id);
    void delete(Long id);
}
