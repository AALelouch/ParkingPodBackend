package com.proyectobackend.parking.presentation.controller;

import com.proyectobackend.parking.business.mapper.requestMapper.UserRequestMapper;
import com.proyectobackend.parking.persistence.entity.Role;
import com.proyectobackend.parking.persistence.entity.User;
import com.proyectobackend.parking.persistence.repository.RoleRepository;
import com.proyectobackend.parking.persistence.repository.UserRepository;
import com.proyectobackend.parking.presentation.controller.response.JwtAuthResponse;
import com.proyectobackend.parking.presentation.controller.resquest.LoginRequest;
import com.proyectobackend.parking.presentation.controller.resquest.SignUpRequest;
import com.proyectobackend.parking.presentation.controller.resquest.exception.RoleNotFoundException;
import com.proyectobackend.parking.presentation.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/parking/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

     @Autowired
     private PasswordEncoder passwordEncoder;

     @Autowired
     private UserRequestMapper userRequestMapper;

     @Autowired
     private JwtTokenProvider jwtTokenProvider;


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        User user = userRequestMapper.signUpToUser(signUpRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(signUpRequest.getRole()).orElseThrow(()-> new RoleNotFoundException(signUpRequest.getRole()));

        user.setRoles(Collections.singleton(userRole));

        userRepository.save(user);


        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }
}
