package com.mrizkisaputra.services;

import com.mrizkisaputra.model.entity.ParkingReport;
import com.mrizkisaputra.repositories.ParkingReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
