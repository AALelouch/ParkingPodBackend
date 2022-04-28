package com.proyectobackend.parking.persistence.repository;

import com.proyectobackend.parking.persistence.entity.VehicleParking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleParkingRepository extends JpaRepository<VehicleParking, Long> {

    @Query("select vp from VehicleParking vp where vp.parking.idSlot = :idSlot")
    VehicleParking findByIdSlot(@Param("idSlot") Long idSlot);
}
