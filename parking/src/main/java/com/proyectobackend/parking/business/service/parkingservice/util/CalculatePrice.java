package com.proyectobackend.parking.business.service.parkingservice.util;

public class CalculatePrice {
    public static double calculatePrice(Long hours, Double priceHour, Double priceDay) {
        if (hours <= 2) {
            return hours * priceHour;
        }
        if (hours <= 23) {
            return priceHour * (hours - 2);
        }

        double days = hours/ 24.0;
        days =  Math.ceil(days);
        return priceDay * days;
    }
}
