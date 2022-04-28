package com.proyectobackend.parking.persistence.repository;

import com.proyectobackend.parking.persistence.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends JpaRepository <Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.plate = :plate")
    Vehicle findByPlate(@Param("plate") String plate);

}
