package com.proyectobackend.parking.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
public class VehicleParking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idCheck;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH,optional = false)
    @JoinColumn(name = "vehicle_id")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Vehicle vehicle;

    @OneToOne(fetch = FetchType.EAGER,  cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "parking_id_slot")
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Parking parking;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime entryDate;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveDate;

    private Long hours;
    private double price;

    public VehicleParking() {
    }

    @Override
    public String toString() {
        return "VehicleParking{" +
                "idCheck=" + idCheck +
                ", vehicle=" + vehicle +
                ", parking=" + parking +
                ", entryDate=" + entryDate +
                ", leaveDate=" + leaveDate +
                ", hours=" + hours +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleParking that = (VehicleParking) o;
        return Double.compare(that.hours, hours) == 0 && Double.compare(that.price, price) == 0 && idCheck.equals(that.idCheck) && vehicle.equals(that.vehicle) && parking.equals(that.parking) && entryDate.equals(that.entryDate) && leaveDate.equals(that.leaveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCheck, vehicle, parking, entryDate, leaveDate, hours, price);
    }

    public Long getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(Long idCheck) {
        this.idCheck = idCheck;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
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
}