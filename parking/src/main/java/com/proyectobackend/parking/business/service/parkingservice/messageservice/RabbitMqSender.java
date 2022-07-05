package com.proyectobackend.parking.business.service.parkingservice.messageservice;

public interface RabbitMqSender {
    void send(ParkingMessage parkingMessage);
}
