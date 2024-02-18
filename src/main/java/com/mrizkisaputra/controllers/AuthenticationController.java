package com.mrizkisaputra.controllers;

import com.mrizkisaputra.model.dto.LoginUserRequestDTO;
import com.mrizkisaputra.model.dto.LoginUserResponseDTO;
import com.mrizkisaputra.model.dto.RegisterUserRequestDTO;
import com.mrizkisaputra.model.entity.User;
import com.mrizkisaputra.model.response.ApiSuccess;
import com.mrizkisaputra.services.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiSuccess<User>> registerUser(@RequestBody RegisterUserRequestDTO userDTO) {
        return authenticationService.registerUser(userDTO);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiSuccess<LoginUserResponseDTO>> loginUser(@RequestBody LoginUserRequestDTO userRequestDTO) {
        return authenticationService.loginUser(userRequestDTO);
    }
}
