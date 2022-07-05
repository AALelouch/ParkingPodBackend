package com.parking.messagelistener.model;

import lombok.Data;

@Data
public class EmailBody {
    private String from = "animafoxy05@gmail.com";
    private String to = "animafoxy05@gmail.com";
    private String subject;
    private String body;
}
