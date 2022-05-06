package com.proyectobackend.parking.presentation.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyectobackend.parking.business.service.parkingservice.GetParkingByPlateQueryImpl;
import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.*;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.AssignRequest;
import com.proyectobackend.parking.presentation.controller.resquest.ParkingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ParkingController {
    @Autowired
    GetTheNumberOfAvailableParkingQuery getTheNumberOfAvailableParkingQuery;

    @Autowired
    ParkingCrudService parkingCrudService;

    @Autowired
    GetParkingAvailableQuery getParkingAvailable;

    @Autowired
    ModifyLeaveDateCommand modifyLeaveDateCommand;

    @Autowired
    GetParkingByPlateQuery getParkingByPlateQuery;

    @Autowired
    AssignVehicleToParkingCommand assignVehicleToParkingCommand;

    @GetMapping("/parking/parkingSlot/available/number/")
    public String getTheNumberOfAvailableParking() {
        return getTheNumberOfAvailableParkingQuery.getTheNumberOfAvailableParking();
    }

    @GetMapping("/parking/parkingSlot/all/")
    public List<ParkingResponse> getAllParking() {
        return parkingCrudService.getAllParking();
    }

    @GetMapping("/parking/parkingSlot/id/{id}/")
    public ParkingResponse getParkingById(@PathVariable Long id) {
        return parkingCrudService.getParkingById(id);
    }

    @GetMapping("/parking/parkingSlot/available/all/")
    public List<ParkingResponse> getAvailableParking() {
        return getParkingAvailable.getParkingAvailable();
    }

    @GetMapping("/parking/parkingSlot/plate/{plate}/")
    public ParkingResponse getParkingByPlate(@PathVariable String plate) {
        return getParkingByPlateQuery.getParkingByPlate(plate);
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

    @PutMapping("/parking/parkingSlot/modifyLeaveDate/{id}/")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void modifyLeaveDate(@PathVariable Long id, @RequestBody     @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime leaveDate) {
        modifyLeaveDateCommand.modifyLeaveDate(id, leaveDate);
    }

    @PutMapping("/parking/parkingSlot/assignVehicle/")
    public ResponseEntity<ParkingResponse> assignVehicleToParking(@RequestBody AssignRequest assignRequest) {
        return new ResponseEntity<>(assignVehicleToParkingCommand.assignVehicleToParking(assignRequest), HttpStatus.OK);
    }

    @DeleteMapping("/parking/parkingSlot/delete/{id}/")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteParking(@PathVariable Long id) {
        parkingCrudService.deleteParking(id);
    }

}
