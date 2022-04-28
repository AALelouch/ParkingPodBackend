package com.proyectobackend.parking.business.service.parkingservice.interfaceforservice;

import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.ParkingRequest;

import java.util.List;

public interface ParkingCrudService {
     List<ParkingResponse> getAllParking();
     ParkingResponse getParkingById(Long id);
     void createParking(ParkingRequest parking);
     void updateParking(ParkingRequest parking, Long id);
     void deleteParking(Long id);
}
