package com.proyectobackend.parking.presentation.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingForVehicleParkingResponse {

    @JsonProperty(value = "idSlot", access = JsonProperty.Access.READ_ONLY)
    private Long idSlot;
    @JsonProperty("available")
    private boolean available;
    @JsonProperty("priceHour")
    private double priceHour;
    @JsonProperty("priceDay")
    private double priceDay;
}
