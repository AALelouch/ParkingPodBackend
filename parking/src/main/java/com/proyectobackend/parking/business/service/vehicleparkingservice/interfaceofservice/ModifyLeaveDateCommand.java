package com.proyectobackend.parking.business.service.vehicleparkingservice.interfaceofservice;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyectobackend.parking.presentation.controller.response.VehicleParkingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface ModifyLeaveDateCommand {
    ResponseEntity<VehicleParkingResponse> modifyLeaveDate(Long id, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
            LocalDateTime leaveDate);
}
