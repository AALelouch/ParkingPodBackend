package com.proyectobackend.parking.business.service.parkingservice.util;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculateHour {
    public static Long calculateHour(LocalDateTime entryDate, LocalDateTime leaveDate) {
        return (Duration.between(entryDate, leaveDate).toMinutes()/ 60);
    }
}
