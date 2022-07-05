package com.proyectobackend.parking.business.service.parkingservice.messageservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleMessage {
    private Long id;

    private  String plate;

    private  String color;

    private  String type;

    @Override
    public String toString() {
        return "VehicleMessage{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
