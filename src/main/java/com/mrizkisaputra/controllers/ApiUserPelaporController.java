package com.mrizkisaputra.controllers;

import com.mrizkisaputra.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ApiUserPelaporController {

    @GetMapping("/users/profile")
    public ResponseEntity<Object> getUserProfile(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        log.info("Object Userr : {}", user);
        return new ResponseEntity<>("Pelapor access level", HttpStatus.OK);
    }
}
