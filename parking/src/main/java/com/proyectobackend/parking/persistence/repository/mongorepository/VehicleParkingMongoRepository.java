package com.proyectobackend.parking.persistence.repository.mongorepository;

import com.proyectobackend.parking.persistence.entity.VehicleParkingMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VehicleParkingMongoRepository extends MongoRepository<VehicleParkingMongoDb, Long> {
    @Query("{ 'vehicle.plate': ?0 }")
    List<VehicleParkingMongoDb> findByPlate(String plate);
}
