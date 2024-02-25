package com.mrizkisaputra.services;

import com.mrizkisaputra.model.entity.ParkingReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ParkingReportService {
    void save(ParkingReport parkingReport);

    Page<ParkingReport> findAllParkingReportByUserId(String id, Pageable pageable);

    ParkingReport findByIdReportParking(String idReportParking, String currentUser);
}
