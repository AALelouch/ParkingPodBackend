package com.proyectobackend.parking.presentation.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParkingResponse {

    private Long idSlot;

    private boolean available;

    private double priceHour;

    private double priceDay;

    private VehicleResponse vehicleResponse;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime entryDate;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveDate;

    private Long hours;

    private double totalPrice;
}
