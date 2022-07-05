package com.proyectobackend.parking.business.service.parkingservice.exception.advice;

import com.proyectobackend.parking.business.service.parkingservice.exception.PlateAlreadyAssignException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PlateAlreadyAssignExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(PlateAlreadyAssignException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String plateAlreadyAssignHandler(PlateAlreadyAssignException ex){
        return ex.getMessage();
    }
}
