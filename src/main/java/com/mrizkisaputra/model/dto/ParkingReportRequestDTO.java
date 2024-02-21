package com.mrizkisaputra.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ParkingReportRequestDTO {
    private MultipartFile file;

    @NotNull(message = "{parking-report-dto.plat-number}")
    private String platNumber;

    @NotNull(message = "{parking-report-dto.longitude}")
    private String longitude;

    @NotNull(message = "{parking-report-dto.latitude}")
    private String latitude;

    private String description;
}
