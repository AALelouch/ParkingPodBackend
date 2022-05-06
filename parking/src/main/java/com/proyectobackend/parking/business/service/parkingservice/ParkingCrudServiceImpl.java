package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.business.mapper.requestMapper.ParkingRequestMapper;
import com.proyectobackend.parking.business.mapper.responseMapper.VehicleResponseMapper;
import com.proyectobackend.parking.business.service.parkingservice.util.CalculateHour;
import com.proyectobackend.parking.business.service.parkingservice.util.CalculatePrice;
import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import com.proyectobackend.parking.persistence.repository.VehicleRepository;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.ParkingRequest;
import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.business.service.parkingservice.exception.ParkingNotFoundException;
import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingCrudServiceImpl implements com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.ParkingCrudService {

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ParkingRequestMapper parkingMapperRequest;

    @Autowired
    ParkingResponseMapper parkingMapperResponse;

    @Autowired
    VehicleResponseMapper vehicleMapperResponse;

    public List<ParkingResponse> getAllParking() {
        List<Parking> parkingList = parkingRepository.findAll();
        List<ParkingResponse> parkingResponseList = new ArrayList<>();
        parkingList.forEach(parking ->{
            ParkingResponse parkingResponse = parkingMapperResponse.ParkingToParkingResponse(parking);
            if (parking.getPlate() != null) {
                parkingResponse.setVehicleResponse(vehicleRepository.findByPlate(parking.getPlate()).map(vehicleMapperResponse::vehicleToVehicleResponse).orElseThrow(() -> new VehicleNotFoundException(parking.getPlate())));
            }
            parkingResponseList.add(parkingResponse);
        });
        return parkingResponseList;
    }


    public ParkingResponse getParkingById(Long id) {
        Parking parking = parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
        ParkingResponse parkingResponse= parkingMapperResponse.ParkingToParkingResponse(parking);
        if (parking.getPlate() != null) {
            parkingResponse.setVehicleResponse(vehicleRepository.findByPlate(parking.getPlate()).map(vehicleMapperResponse::vehicleToVehicleResponse).orElseThrow(() -> new VehicleNotFoundException(parking.getPlate())));
        }
        return parkingResponse;
    }

    public void createParking(ParkingRequest parkingRequest) {
        Parking parkingToCreate =parkingMapperRequest.parkingForEntityRequestToParking(parkingRequest);
        parkingRepository.save(parkingToCreate);
    }

    public void updateParking(ParkingRequest parkingRequest, Long id) {
        Parking parking = parkingMapperRequest.parkingForEntityRequestToParking(parkingRequest);
        Parking parkingToUpdate = parkingRepository.findById(id).map(parkingMap -> {
            parkingMap.setAvailable(parking.isAvailable());
            parkingMap.setPriceDay(parking.getPriceDay());
            parkingMap.setPriceHour(parking.getPriceHour());
            vehicleRepository.findByPlate(parking.getPlate()).orElseThrow(() -> new VehicleNotFoundException(id));
            parkingMap.setPlate(parking.getPlate());
            parkingMap.setEntryDate(parking.getEntryDate());
            parkingMap.setLeaveDate(parking.getLeaveDate());
            parkingMap.setHours(CalculateHour.calculateHour(parking.getEntryDate(), parking.getLeaveDate()));
            parkingMap.setTotalPrice(CalculatePrice.calculatePrice(parking.getHours(), parking.getPriceHour(), parking.getPriceDay()));

            return parkingRepository.save(parkingMap);
        }).orElseGet(() -> {parking.setIdSlot(id); return parkingRepository.save(parking);});
    }

    public void deleteParking(Long id) {
        parkingRepository.deleteById(id);
    }

}
