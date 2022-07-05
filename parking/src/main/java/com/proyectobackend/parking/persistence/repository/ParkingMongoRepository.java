package com.proyectobackend.parking.persistence.repository;

import com.proyectobackend.parking.persistence.entity.ParkingForMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ParkingMongoRepository extends MongoRepository<ParkingForMongoDb, Long> {
    @Query("{'vehicleForMongoDb.plate': ?0}")
    List<ParkingForMongoDb> findByPlate(String plate);

}
