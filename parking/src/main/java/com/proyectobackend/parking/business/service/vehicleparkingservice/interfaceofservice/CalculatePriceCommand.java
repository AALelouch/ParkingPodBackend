package com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice;


import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CalculatePriceCommand {
    ResponseEntity<VehicleParkingResponse> calculatePrice(Long id);
}
