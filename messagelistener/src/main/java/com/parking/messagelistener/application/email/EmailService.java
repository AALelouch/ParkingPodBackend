package com.parking.messagelistener.application.email;

import com.parking.messagelistener.model.EmailBody;
import com.parking.messagelistener.model.ParkingMessage;

public interface EmailService {
    void send(EmailBody parkingMessage);
    EmailBody createEmailBody(ParkingMessage message);
}
