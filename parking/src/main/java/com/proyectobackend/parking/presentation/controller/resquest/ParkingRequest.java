package com.proyectobackend.parking.presentation.controller.resquest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingRequest {

    private boolean available;

    private double priceHour;

    private double priceDay;
}
