package com.parking.messagelistener.application.email;

import com.parking.messagelistener.model.EmailBody;
import com.parking.messagelistener.model.ParkingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;


    @Override
    public void send(EmailBody parkingMessage) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom(parkingMessage.getFrom());
            helper.setTo(parkingMessage.getTo());
            helper.setSubject(parkingMessage.getSubject());
            helper.setText(parkingMessage.getBody());
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    @Override
    public EmailBody createEmailBody(ParkingMessage message) {
        EmailBody emailBody = new EmailBody();
        emailBody.setSubject("Parking Check");
        emailBody.setBody("Parking Check\n" +
                "Vehicle\n" +
                "License Plate: " + message.getVehicleMessage().getPlate() + "\n" +
                "Color: " + message.getVehicleMessage().getColor() + "\n" +
                "Type: " + message.getVehicleMessage().getType() + "\n" +

                "Parking\n" +
                "Slot: " + message.getIdSlot() + "\n" +
                "Price hour: " + message.getPriceHour() + "\n" +
                "Price day: " + message.getPriceDay() + "\n" +
                "Entry Date: " + message.getEntryDate() + "\n" +
                "Leave Date: " + message.getLeaveDate() + "\n" +
                "Hours: " + message.getHours() + "\n" +
                "Total: " + message.getTotalPrice()
                );

        return emailBody;
    }
}
