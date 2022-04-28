package com.proyectobackend.parking.presentation.controller.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleForVehicleParkingRequest {
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
