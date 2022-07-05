package com.proyectobackend.parking.persistence.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleForMongoDb {
    private Long id;

    private  String plate;

    private  String color;

    private  String type;
}
