package com.mrizkisaputra.controllers;

import com.mrizkisaputra.model.dto.ParkingReportRequestDTO;
import com.mrizkisaputra.model.dto.ParkingReportResponseDTO;
import com.mrizkisaputra.model.response.ApiSuccess;
import com.mrizkisaputra.services.ImageUploadingService;
import com.mrizkisaputra.services.UserPelaporService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class ApiUserPelaporController {
    @Autowired
    private ImageUploadingService imageUploadingService;

    @Autowired
    private UserPelaporService userPelaporService;
    @GetMapping("/profile")
    public ResponseEntity<Object> getUserProfile(Authentication authentication) {
        return new ResponseEntity<>("Pelapor access level", HttpStatus.OK);
    }

    @PostMapping(path = "/parking/report", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiSuccess<Object>> createReportParking(@ModelAttribute ParkingReportRequestDTO requestDTO, Authentication currentUser) {
//        upload dulu gambar ke firestore
        String uploaded = imageUploadingService.upload(requestDTO.getFile());
        return userPelaporService.createReportParking(uploaded, requestDTO, currentUser.getName());
    }

    @GetMapping(path = "/parking/report")
    public ResponseEntity<ApiSuccess<ParkingReportResponseDTO>> getAllReportParking(Authentication currentUser) {
        return userPelaporService.getAllParkingReport(currentUser.getName());
    }

    @GetMapping(path = "/parking/report/{id}")
    public ResponseEntity<ApiSuccess<ParkingReportResponseDTO>> getReportParking(@PathVariable(name = "id") String id, Authentication currentUser) {
        return userPelaporService.getParkingReport(id, currentUser.getName());
    }

}
