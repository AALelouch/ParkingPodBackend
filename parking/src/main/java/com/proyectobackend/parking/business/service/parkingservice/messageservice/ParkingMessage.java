package com.proyectobackend.parking.business.service.parkingservice.messageservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingMessage {

    private Long idSlot;

    private double priceHour;

    private double priceDay;

    private VehicleMessage vehicleMessage;

    private String entryDate;

    private String leaveDate;
    private Long hours;
    private double totalPrice;

    @Override
    public String toString() {
        return "ParkingMessage[" +
                "idSlot=" + idSlot +
                ", priceHour=" + priceHour +
                ", priceDay=" + priceDay +
                ", vehicleResponse=" + vehicleMessage +
                ", entryDate=" + entryDate +
                ", leaveDate=" + leaveDate +
                ", hours=" + hours +
                ", totalPrice=" + totalPrice +
                ']';
    }
}
