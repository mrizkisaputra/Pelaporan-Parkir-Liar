package com.mrizkisaputra.services;

import com.mrizkisaputra.model.entity.ParkingReport;
import com.mrizkisaputra.repositories.ParkingReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ParkingReportServiceImpl implements ParkingReportService {
    @Autowired
    private ParkingReportRepository parkingReportRepository;
    @Override
    public void save(ParkingReport parkingReport) {
        parkingReportRepository.save(parkingReport);
    }

    @Override
    public Page<ParkingReport> findAllParkingReportByUserId(String id, Pageable pageable) {
        return parkingReportRepository.findAllByUsers_Id(id, pageable);
    }

    @Override
    public ParkingReport findByIdReportParking(String idReportParking, String currentUser) {
        ParkingReport parkingReport = parkingReportRepository.findByIdAndUsers_Username(idReportParking, currentUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "laporan parkir liar dengan id " + idReportParking + " tidak ditemukan"));
        return parkingReport;
    }
}
