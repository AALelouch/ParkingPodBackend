package com.proyectobackend.parking.persistence.repository;

import com.proyectobackend.parking.persistence.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

    @Query("select p from Parking p where p.available = true")
    List<Parking> findAllAvailable();

    Optional<Parking> findByPlate(String plate);
}
