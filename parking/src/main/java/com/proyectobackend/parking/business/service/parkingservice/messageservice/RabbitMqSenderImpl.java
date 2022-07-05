package com.proyectobackend.parking.business.service.parkingservice.messageservice;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqSenderImpl implements RabbitMqSender {
    @Autowired
    private AmqpTemplate rabbitMqTemplate;

    @Value("${parking.rabbitmq.exchange}")
    private String exchange;

    @Value("${parking.rabbitmq.routingkey}")
    private String routingKey;

    public void send(ParkingMessage parkingMessage) {
        rabbitMqTemplate.convertAndSend(exchange, routingKey, parkingMessage);
    }
}
