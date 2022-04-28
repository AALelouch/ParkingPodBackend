package com.proyectobackend.parking.business.mapper.requestMapper;

import com.proyectobackend.parking.persistence.entity.User;
import com.proyectobackend.parking.presentation.controller.resquest.SignUpRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    User signUpToUser(SignUpRequest signUpRequest);
}
