package com.proyectobackend.parking.business.mapper.responseMapper;

import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.entity.Vehicle;
import com.proyectobackend.parking.persistence.entity.VehicleParking;
import com.proyectobackend.parking.presentation.controller.response.ParkingForVehicleParkingResponse;
import com.proyectobackend.parking.presentation.controller.response.VehicleForVehicleParkingResponse;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleParkingResponseMapper {

    ParkingForVehicleParkingResponse parkingToParkingForVehicleParkingResponse(Parking parking);
    Parking parkingForVehicleParkingResponseToParking(ParkingForVehicleParkingResponse parkingResponse);
    VehicleForVehicleParkingResponse vehicleToVehicleForVehicleParkingResponse(Vehicle vehicle);
    Vehicle vehicleForVehicleParkingResponseToVehicle(VehicleForVehicleParkingResponse vehicleParkingResponse);

    VehicleParkingResponse vehicleParkingToVehicleParkingResponse(VehicleParking vehicleParking);
    VehicleParking vehicleParkingResponseToVehicleParking(VehicleParkingResponse vehicleParkingResponse);

}
