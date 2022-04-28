package com.proyectobackend.parking.business.service.vehicleservice.exception.advice;

import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VehicleNotFondExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(VehicleNotFoundException.class)
    @ResponseStatus(value = org.springframework.http.HttpStatus.NOT_FOUND)
    public String vehicleNotFondExceptionHandler(VehicleNotFoundException ex) {
        return ex.getMessage();
    }
}
