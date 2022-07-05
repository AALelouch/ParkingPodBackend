package com.proyectobackend.parking.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

@Getter
@Setter
@Document
public class ParkingForMongoDb {

    private Long idSlot;

    private boolean available;

    private double priceHour;

    private double priceDay;

    private VehicleForMongoDb vehicleForMongoDb;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime entryDate;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveDate;

    private Long hours;

    private double totalPrice;
}
