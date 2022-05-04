package com.proyectobackend.parking.presentation.controller.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingRequest {

    @JsonProperty("available")
    private boolean available;
    @JsonProperty("priceHour")
    private double priceHour;
    @JsonProperty("priceDay")
    private double priceDay;
}
