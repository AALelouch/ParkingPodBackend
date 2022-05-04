package com.proyectobackend.parking.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "VehicleParking")
public class VehicleParkingMongoDb {
    @Id
    private Long idCheck;
    private Vehicle vehicle;
    private Parking parking;
    private LocalDateTime entryDate;
    private LocalDateTime leaveDate;
    private Long hours;
    private double price;
}
