package com.proyectobackend.parking.presentation.controller.resquest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VehicleParkingRequest {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idCheck;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private VehicleForVehicleParkingRequest vehicle;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ParkingForVehicleParkingRequest parking;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime entryDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveDate;

    public Long getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(Long idCheck) {
        this.idCheck = idCheck;
    }

    public VehicleForVehicleParkingRequest getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleForVehicleParkingRequest vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingForVehicleParkingRequest getParking() {
        return parking;
    }

    public void setParking(ParkingForVehicleParkingRequest parking) {
        this.parking = parking;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDateTime leaveDate) {
        this.leaveDate = leaveDate;
    }
}