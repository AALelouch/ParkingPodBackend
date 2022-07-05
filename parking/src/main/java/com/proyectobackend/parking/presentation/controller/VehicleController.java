package com.proyectobackend.parking.presentation.controller;

import com.proyectobackend.parking.presentation.controller.resquest.VehicleRequest;
import com.proyectobackend.parking.presentation.controller.response.VehicleResponse;
import com.proyectobackend.parking.business.service.vehicleservice.interfaceforservice.GetByPlateOfVehicleQuery;
import com.proyectobackend.parking.business.service.vehicleservice.interfaceforservice.VehicleCrudService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
public class VehicleController {
    @Autowired
    private VehicleCrudService vehicleCrudService;
    @Autowired
    private GetByPlateOfVehicleQuery getByPlateOfVehicleQuery;

    @GetMapping("/parking/vehicle/all/")
    public List<VehicleResponse> getAllVehicles(){
        return vehicleCrudService.getVehicles();
    }

    @GetMapping("/parking/vehicle/plate/{plate}/")
    public VehicleResponse getVehicleByPlate(@PathVariable String plate){
        return getByPlateOfVehicleQuery.getVehicleByPlate(plate);
    }

    @GetMapping("/parking/vehicle/id/{id}/")
    public VehicleResponse getVehicleById(@PathVariable Long id){
        return vehicleCrudService.getVehicleById(id);
    }

    @PostMapping("/parking/vehicle/add/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addVehicle(@RequestBody VehicleRequest vehicleRequest){
        vehicleCrudService.createVehicle(vehicleRequest);
    }

    @PutMapping("/parking/vehicle/update/{id}/")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateVehicle(@RequestBody VehicleRequest vehicleRequest, @PathVariable Long id){
        vehicleCrudService.updateVehicle(vehicleRequest, id);
    }

    @DeleteMapping("/parking/vehicle/delete/{id}/")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable Long id){
        vehicleCrudService.deleteVehicle(id);
    }
}
