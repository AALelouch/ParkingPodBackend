package com.proyectobackend.parking.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idSlot;
    private boolean available;
    private double priceHour;
    private double priceDay;

    public Parking() {
    }

    public Parking(Long idSlot, boolean available, double priceHour, double priceDay) {
        this.idSlot = idSlot;
        this.available = available;
        this.priceHour = priceHour;
        this.priceDay = priceDay;
    }

    public Parking(boolean available, double priceHour, double priceDay) {
        this.available = available;
        this.priceHour = priceHour;
        this.priceDay = priceDay;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "idSlot=" + idSlot +
                ", available=" + available +
                ", priceHour=" + priceHour +
                ", priceDay=" + priceDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return idSlot.equals(parking.idSlot) && available == parking.available && priceHour == parking.priceHour && priceDay == parking.priceDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSlot, available, priceHour, priceDay);
    }

    public Long getIdSlot() {
        return idSlot;
    }

    public void setIdSlot(Long idSlot) {
        this.idSlot = idSlot;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(double priceHour) {
        this.priceHour = priceHour;
    }

    public double getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(double priceDay) {
        this.priceDay = priceDay;
    }
}
