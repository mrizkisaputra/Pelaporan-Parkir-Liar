package com.mrizkisaputra.controllers;

import com.mrizkisaputra.model.dto.RegisterUserDTO;
import com.mrizkisaputra.model.entity.User;
import com.mrizkisaputra.model.response.ApiSuccess;
import com.mrizkisaputra.services.AuthenticationService;
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
    public ResponseEntity<ApiSuccess<User>> registerUser(@RequestBody RegisterUserDTO userDTO) {
        return authenticationService.registerUser(userDTO);
    }
}
