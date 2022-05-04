package com.proyectobackend.parking.presentation.controller.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingForVehicleParkingRequest {

    @JsonProperty(value = "idSlot", access = JsonProperty.Access.WRITE_ONLY)
    private Long idSlot;
}
