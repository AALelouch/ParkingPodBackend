package com.proyectobackend.parking.presentation.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class VehicleParkingResponse {

    @JsonProperty("idCheck")
    private Long idCheck;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private VehicleForVehicleParkingResponse vehicle;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ParkingForVehicleParkingResponse parking;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime entryDate;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime leaveDate;
    private  Long hours;
    private  double price;
}
