package com.parking.messagelistener.application.amqp.listener;

import com.parking.messagelistener.model.ParkingMessage;

public interface RabbitMqListener {
    void receive(ParkingMessage parkingMessage);
}
