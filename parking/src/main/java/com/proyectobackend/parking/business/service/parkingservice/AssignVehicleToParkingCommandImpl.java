package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleResponseMapper;
import com.proyectobackend.parking.business.service.parkingservice.exception.ParkingNotFoundException;
import com.proyectobackend.parking.business.service.parkingservice.exception.PlateAlreadyAssignException;
import com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.AssignVehicleToParkingCommand;
import com.proyectobackend.parking.business.service.parkingservice.util.CalculateHour;
import com.proyectobackend.parking.business.service.parkingservice.util.CalculatePrice;
import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.entity.Vehicle;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.AssignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignVehicleToParkingCommandImpl implements AssignVehicleToParkingCommand {

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingResponseMapper parkingMapperResponse;

    @Autowired
    VehicleResponseMapper vehicleMapperResponse;

    @Override
    public ParkingResponse assignVehicleToParking(AssignRequest assignRequest) {
        if(parkingRepository.findByPlate(assignRequest.getPlate()).isPresent()){
            throw new PlateAlreadyAssignException(assignRequest.getPlate());
        }

        Parking parking = parkingRepository.findById(assignRequest.getIdSlot()).orElseThrow(()-> new ParkingNotFoundException(assignRequest.getIdSlot()) );
        Vehicle vehicle = vehicleRepository.findByPlate(assignRequest.getPlate()).orElseThrow(()-> new ParkingNotFoundException(assignRequest.getPlate()) );
        parking.setPlate(vehicle.getPlate());
        parking.setEntryDate(assignRequest.getEntryDate());
        parking.setLeaveDate(assignRequest.getLeaveDate());
        parking.setHours(CalculateHour.calculateHour(assignRequest.getEntryDate(),assignRequest.getLeaveDate()));
        parking.setTotalPrice(CalculatePrice.calculatePrice(parking.getHours(),parking.getPriceHour(), parking.getPriceDay()));
        parking.setAvailable(false);
        parkingRepository.save(parking);

        ParkingResponse parkingResponse = parkingMapperResponse.ParkingToParkingResponse(parking);
        parkingResponse.setVehicleResponse(vehicleMapperResponse.vehicleToVehicleResponse(vehicle));
        return parkingResponse;
    }
}
