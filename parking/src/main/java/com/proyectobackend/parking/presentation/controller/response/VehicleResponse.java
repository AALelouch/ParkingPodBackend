package com.proyectobackend.parking.presentation.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleResponse {

    private Long id;

    private  String plate;

    private  String color;

    private  String type;
}

