package com.proyectobackend.parking.presentation.controller.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleForVehicleParkingResponse {
    @JsonProperty(value = "id")
    @JsonIgnore
    private Long id;
    @JsonProperty("plate")
    private  String plate;
    @JsonProperty("color")
    private  String color;
    @JsonProperty("type")
    private  String type;
}
