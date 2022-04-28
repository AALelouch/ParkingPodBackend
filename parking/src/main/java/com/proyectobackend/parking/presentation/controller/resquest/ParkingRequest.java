package com.proyectobackend.parking.presentation.controller.resquest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingRequest {

    @JsonProperty("available")
    private boolean available;
    @JsonProperty("priceHour")
    private double priceHour;
    @JsonProperty("priceDay")
    private double priceDay;

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