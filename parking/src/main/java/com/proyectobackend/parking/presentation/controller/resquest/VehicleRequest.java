package com.proyectobackend.parking.presentation.controller.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequest {
    @JsonProperty("plate")
    private  String plate;
    @JsonProperty("color")
    private  String color;
    @JsonProperty("type")
    private  String type;
}

