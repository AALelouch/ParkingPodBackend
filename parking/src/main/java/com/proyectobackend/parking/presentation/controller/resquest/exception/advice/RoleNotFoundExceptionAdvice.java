package com.proyectobackend.parking.presentation.controller.resquest.exception.advice;

import com.proyectobackend.parking.presentation.controller.resquest.exception.RoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RoleNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String roleNotFoundHandler(RoleNotFoundException ex) {
        return ex.getMessage();
    }
}
