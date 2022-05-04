package com.proyectobackend.parking.presentation.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponse {
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private Long id;
    @JsonProperty("plate")
    private  String plate;
    @JsonProperty("color")
    private  String color;
    @JsonProperty("type")
    private  String type;
}

