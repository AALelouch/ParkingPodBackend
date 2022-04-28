package com.proyectobackend.parking.presentation.controller;

import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.GetParkingAvailableQuery;
import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.GetTheNumberOfAvailableParkingQuery;
import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.ParkingCrudService;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.ParkingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {
    @Autowired
    GetTheNumberOfAvailableParkingQuery getTheNumberOfAvailableParkingQuery;

    @Autowired
    ParkingCrudService parkingCrudService;

    @Autowired
    GetParkingAvailableQuery getParkingAvailable;

    @GetMapping("/parking/parkingSlot/available/number/")
    public String getTheNumberOfAvailableParking() {
        return getTheNumberOfAvailableParkingQuery.getTheNumberOfAvailableParking();
    }

    @GetMapping("/parking/parkingSlot/all/")
    public List<ParkingResponse> getAllParking() {
        return parkingCrudService.getAllParking();
    }

    @GetMapping("/parking/parkingSlot/{id}/")
    public ParkingResponse getParkingById(@PathVariable Long id) {
        return parkingCrudService.getParkingById(id);
    }

    @GetMapping("/parking/parkingSlot/available/all/")
    public List<ParkingResponse> getAvailableParking() {
        return getParkingAvailable.getParkingAvailable();
    }

    @PostMapping("/parking/parkingSlot/add/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createParking(@RequestBody ParkingRequest parkingRequest) {
        parkingCrudService.createParking(parkingRequest);
    }

    @PutMapping("/parking/parkingSlot/update/{id}/")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateParking(@PathVariable Long id, @RequestBody ParkingRequest parkingRequest) {
        parkingCrudService.updateParking(parkingRequest, id);
    }

    @DeleteMapping("/parking/parkingSlot/delete/{id}/")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteParking(@PathVariable Long id) {
        parkingCrudService.deleteParking(id);
    }

}
