package com.proyectobackend.parking.presentation.controller.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParkingForVehicleParkingRequest {

    @JsonProperty(value = "idSlot", access = JsonProperty.Access.WRITE_ONLY)
    private Long idSlot;

    public Long getIdSlot() {
        return idSlot;
    }

    public void setIdSlot(Long idSlot) {
        this.idSlot = idSlot;
    }
}
