package com.mrizkisaputra.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pengawas")
public class ApiUserPengawasController {

    @GetMapping(path = "/info")
    public ResponseEntity<Object> getInfo() {
        return new ResponseEntity<>("pengawas access level", HttpStatus.OK);
    }
}
