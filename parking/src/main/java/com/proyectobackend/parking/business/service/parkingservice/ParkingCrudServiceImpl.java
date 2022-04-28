package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.business.mapper.requestMapper.ParkingRequestMapper;
import com.proyectobackend.parking.presentation.controller.response.ParkingResponse;
import com.proyectobackend.parking.presentation.controller.resquest.ParkingRequest;
import com.proyectobackend.parking.business.mapper.responseMapper.ParkingResponseMapper;
import com.proyectobackend.parking.business.service.parkingservice.exception.ParkingNotFoundException;
import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingCrudServiceImpl implements com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.ParkingCrudService {

    @Autowired
    ParkingRepository parkingRepository;

    @Autowired
    ParkingRequestMapper parkingMapperRequest;

    @Autowired
    ParkingResponseMapper parkingMapperResponse;

    public List<ParkingResponse> getAllParking() {
        return parkingRepository.findAll().stream().map(parkingMapperResponse::ParkingToParkingForEntityResponse).collect(Collectors.toList());
    }


    public ParkingResponse getParkingById(Long id) {
        Parking parking = parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
        return parkingMapperResponse.ParkingToParkingForEntityResponse(parking);
    }

    public void createParking(ParkingRequest parkingRequest) {
        Parking parkingToCreate = parkingRepository.save(parkingMapperRequest.parkingForEntityRequestToParking(parkingRequest));
    }

    public void updateParking(ParkingRequest parkingRequest, Long id) {
        Parking parking = parkingMapperRequest.parkingForEntityRequestToParking(parkingRequest);
        Parking parkingToUpdate = parkingRepository.findById(id).map(parkingMap -> {
            parkingMap.setAvailable(parking.isAvailable());
            parkingMap.setPriceDay(parking.getPriceDay());
            parkingMap.setPriceHour(parking.getPriceHour());
            return parkingRepository.save(parkingMap);
        }).orElseGet(() -> {parking.setIdSlot(id); return parkingRepository.save(parking);});
    }

    public void deleteParking(Long id) {
        parkingRepository.deleteById(id);
    }

}
