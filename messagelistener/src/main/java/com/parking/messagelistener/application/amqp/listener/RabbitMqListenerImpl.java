package com.parking.messagelistener.application.amqp.listener;

import com.parking.messagelistener.application.email.EmailService;
import com.parking.messagelistener.model.ParkingMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListenerImpl implements RabbitMqListener {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${parking.rabbitmq.queue}")
    public void receive(ParkingMessage parkingMessage) {
        emailService.send(emailService.createEmailBody(parkingMessage));
        System.out.println("Received message: " + parkingMessage);
    }
}
