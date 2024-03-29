package com.mrizkisaputra.repositories;

import com.mrizkisaputra.model.entity.ParkingReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingReportRepository extends JpaRepository<ParkingReport, String> {
    Page<ParkingReport> findAllByUsers_Id(String id, Pageable pageable);

    Optional<ParkingReport> findByIdAndUsers_Username(String idReportParking, String user);
}
