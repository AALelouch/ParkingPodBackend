package com.proyectobackend.parking.presentation.controller;

import com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice.CalculatePriceCommand;
import com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice.ModifyLeaveDateCommand;
import com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice.VehicleParkingCrudService;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.VehicleParkingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class VehicleParkingController {

    @Autowired
    VehicleParkingCrudService vehicleParkingCrudService;

    @Autowired
    ModifyLeaveDateCommand modifyLeaveDate;

    @Autowired
    CalculatePriceCommand calculatePriceCommand;

    @GetMapping("/parking/vehicleParking/all")
    public List<VehicleParkingResponse> getVehicleParking() {
        return vehicleParkingCrudService.findAll();
    }

    @GetMapping("/parking/vehicleParking/id/{id}")
    public ResponseEntity<VehicleParkingResponse> getVehicleParkingById(@PathVariable Long id) {
        return vehicleParkingCrudService.findById(id);
    }

    @PostMapping("/parking/vehicleParking/calculatePrice/{id}")
    public ResponseEntity<VehicleParkingResponse> calculatePrice(@PathVariable Long id) {
        return calculatePriceCommand.calculatePrice(id);
    }

    @PostMapping("/parking/vehicleParking/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveVehicleParking(@RequestBody VehicleParkingRequest vehicleParkingDtoPost) {
        vehicleParkingCrudService.save(vehicleParkingDtoPost);
    }

    @PutMapping("/parking/vehicleParking/modifyLeaveDate/{id}")
    public ResponseEntity<VehicleParkingResponse> modifyLeaveDate(@PathVariable Long id,  @RequestBody LocalDateTime leaveDate) {
        return modifyLeaveDate.modifyLeaveDate(id, leaveDate);
    }

    @PutMapping("/parking/vehicleParking/modify/{id}/")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void modifyVehicleParking(@PathVariable Long id, @RequestBody VehicleParkingRequest vehicleParkingDtoPut) {
        vehicleParkingCrudService.update(vehicleParkingDtoPut, id);
    }

    @DeleteMapping("/parking/vehicleParking/delete/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVehicleParking(@PathVariable Long id) {
        vehicleParkingCrudService.delete(id);
    }

}
