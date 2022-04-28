package com.proyectobackend.parking.business.service.parkingservice;

import com.proyectobackend.parking.persistence.entity.Parking;
import com.proyectobackend.parking.persistence.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTheNumberOfAvailableParkingQueryImpl implements com.proyectobackend.parking.business.service.parkingservice.interfaceforservice.GetTheNumberOfAvailableParkingQuery {

    @Autowired
    ParkingRepository parkingRepository;

    public String getTheNumberOfAvailableParking() {
        List<Parking> parkingList = parkingRepository.findAllAvailable();
        return "The number of available parking is: " + parkingList.size();
    }
}
