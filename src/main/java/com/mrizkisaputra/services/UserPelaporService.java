package com.mrizkisaputra.services;

import com.mrizkisaputra.model.dto.ParkingReportRequestDTO;
import com.mrizkisaputra.model.dto.ParkingReportResponseDTO;
import com.mrizkisaputra.model.entity.ParkingReport;
import com.mrizkisaputra.model.response.ApiSuccess;
import org.springframework.http.ResponseEntity;

public interface UserPelaporService {
    ResponseEntity<ApiSuccess<Object>> createReportParking(String photoUrl, ParkingReportRequestDTO requestDTO, String currentUser);

    ResponseEntity<ApiSuccess<ParkingReportResponseDTO>> getAllParkingReport(String currentUser);

    ResponseEntity<ApiSuccess<ParkingReportResponseDTO>> getParkingReport(String idReportParking, String currentUser);

    ResponseEntity<ApiSuccess<Object>> deleteReportParking(String idReportParking, String currentUser);
}
