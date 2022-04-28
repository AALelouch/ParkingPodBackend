package com.proyectobackend.parking.business.service.parkingservice.exception.advice;

import com.proyectobackend.parking.business.service.parkingservice.exception.ParkingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ParkingNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(ParkingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String parkingNotFoundHandler(ParkingNotFoundException ex) {
        return ex.getMessage();
    }
}
