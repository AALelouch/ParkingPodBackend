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

    @Override
    public String toString() {
        return "VehicleParkingDTO{" +
                "vehicle=" + vehicle +
                ", parking=" + parking +
                ", entryDate=" + entryDate +
                ", leaveDate=" + leaveDate +
                ", hours=" + hours +
                ", price=" + price +
                '}';
    }

    public Long getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(Long idCheck) {
        this.idCheck = idCheck;
    }

    public VehicleForVehicleParkingResponse getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleForVehicleParkingResponse vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingForVehicleParkingResponse getParking() {
        return parking;
    }

    public void setParking(ParkingForVehicleParkingResponse parking) {
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

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleParkingResponse that = (VehicleParkingResponse) o;
        return Double.compare(that.price, price) == 0 && vehicle.equals(that.vehicle) && parking.equals(that.parking) && entryDate.equals(that.entryDate) && leaveDate.equals(that.leaveDate) && hours.equals(that.hours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicle, parking, entryDate, leaveDate, hours, price);
    }
}
