package com.proyectobackend.parking.business.service.vehicleservice.exception.advice;

import com.proyectobackend.parking.business.service.vehicleservice.exception.VehicleAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class VehicleAlreadyExistExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(VehicleAlreadyExistException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public String VehicleAlreadyExistExceptionHandler(VehicleAlreadyExistException ex){return ex.getMessage();}

}
