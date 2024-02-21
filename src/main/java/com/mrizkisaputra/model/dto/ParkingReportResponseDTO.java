package com.mrizkisaputra.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingReportResponseDTO {
    private String id;

    private String photoUrl;

    private String platNumber;

    private String longitude;

    private String latitude;

    private String description;
}
