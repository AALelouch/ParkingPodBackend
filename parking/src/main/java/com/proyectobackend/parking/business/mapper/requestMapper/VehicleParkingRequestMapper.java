package com.proyectobackend.parking.business.mapper.requestMapper;

import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.entity.Vehicle;
import com.proyectobackend.parking.persistence.entity.VehicleParking;
import com.proyectobackend.parking.presentation.controller.resquest.ParkingForVehicleParkingRequest;
import com.proyectobackend.parking.presentation.controller.resquest.VehicleForVehicleParkingRequest;
import com.proyectobackend.parking.presentation.controller.resquest.VehicleParkingRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleParkingRequestMapper {

    ParkingForVehicleParkingRequest parkingToParkingForVehicleParkingRequest(Parking parking);
    Parking parkingForVehicleParkingRequestToParking(ParkingForVehicleParkingRequest parkingDto);
    VehicleForVehicleParkingRequest vehicleToVehicleForVehicleParkingRequest(Vehicle vehicle);
    Vehicle vehicleForVehicleParkingRequestToVehicle(VehicleForVehicleParkingRequest vehicleDto);

    VehicleParkingRequest vehicleParkingToVehicleParkingRequest(VehicleParking vehicleParking);
    VehicleParking vehicleParkingRequestToVehicleParking(VehicleParkingRequest vehicleParkingDto);
}
