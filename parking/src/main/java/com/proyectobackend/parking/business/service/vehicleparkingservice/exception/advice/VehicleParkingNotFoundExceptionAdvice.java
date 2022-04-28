package com.proyectobackend.parking.business.service.vehicleparkingservice.exception.advice;

import com.proyectobackend.parking.business.service.vehicleparkingservice.exception.VehicleParkingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VehicleParkingNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(VehicleParkingNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    String vehicleParkingNotFoundHandler(VehicleParkingNotFoundException ex) {
        return ex.getMessage();
    }
}
