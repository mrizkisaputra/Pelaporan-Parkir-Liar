package com.mrizkisaputra.services;

import com.mrizkisaputra.model.dto.ParkingReportRequestDTO;
import com.mrizkisaputra.model.dto.ParkingReportResponseDTO;
import com.mrizkisaputra.model.entity.ParkingReport;
import com.mrizkisaputra.model.entity.User;
import com.mrizkisaputra.model.response.ApiSuccess;
import com.mrizkisaputra.model.response.PagingResponse;
import com.mrizkisaputra.repositories.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Service
public class UserPelaporServiceImpl implements UserPelaporService, MessageSourceAware {
    private MessageSource messageSource;

    @Autowired
    private ParkingReportService parkingReportService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Transactional
    @Override
    public ResponseEntity<ApiSuccess<Object>> createReportParking(String photoUrl, ParkingReportRequestDTO requestDTO, String currentUser) {
        Set<ConstraintViolation<ParkingReportRequestDTO>> validated = validator.validate(requestDTO);
        if (!validated.isEmpty()) throw new ConstraintViolationException("Validated failed", validated);

        // user yang sedang login saat ini
        User user = userRepository.findByUsername(currentUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nama user yang sedang login tidak ditemukan"));

        ParkingReport data = new ParkingReport();
        data.setPhotoUrl(photoUrl);
        data.setPlatNumber(requestDTO.getPlatNumber());
        data.setLongitude(requestDTO.getLongitude());
        data.setLatitude(requestDTO.getLatitude());
        data.setDescription(requestDTO.getDescription());
        data.setUsers(Set.of(user));
        parkingReportService.save(data);

        ApiSuccess<Object> apiSuccess = new ApiSuccess<>(HttpStatus.CREATED, messageSource.getMessage("create-parking-report.success", null, Locale.getDefault()));
        return buildResponseEntity(apiSuccess, HttpStatus.CREATED);
    }

    @Transactional
    @Override
    public ResponseEntity<ApiSuccess<ParkingReportResponseDTO>> getAllParkingReport(String currentUser) {
        User user = userRepository.findByUsername(currentUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user "+currentUser+" yang sedang login tidak ditemukan"));

        Pageable pageable = PageRequest.of(0, 10);
        Page<ParkingReport> parkingReports = parkingReportService.findAllParkingReportByUserId(user.getId(), pageable);
        List<ParkingReportResponseDTO> response = new ArrayList<>();
        for (ParkingReport e : parkingReports) {
            ParkingReportResponseDTO data = ParkingReportResponseDTO.builder()
                    .id(e.getId())
                    .photoUrl(e.getPhotoUrl())
                    .platNumber(e.getPlatNumber())
                    .longitude(e.getLongitude())
                    .latitude(e.getLatitude())
                    .description(e.getDescription())
                    .build();
            response.add(data);
        }

        ApiSuccess<ParkingReportResponseDTO> apiSuccess = new ApiSuccess<>(
                HttpStatus.OK,
                "berhasil mengambil semua pengaduan laporan parkir liar",
                response,
                new PagingResponse(parkingReports.getTotalElements(), parkingReports.getTotalPages(), parkingReports.getSize()));
        return buildResponseEntity(apiSuccess, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiSuccess<ParkingReportResponseDTO>> getParkingReport(String idReportParking, String currentUser) {
        ParkingReport e = parkingReportService.findByIdReportParking(idReportParking, currentUser);
        ParkingReportResponseDTO data = ParkingReportResponseDTO.builder()
                .id(e.getId())
                .photoUrl(e.getPhotoUrl())
                .platNumber(e.getPlatNumber())
                .longitude(e.getLongitude())
                .latitude(e.getLatitude())
                .description(e.getDescription())
                .build();
        ApiSuccess<ParkingReportResponseDTO> apiSuccess = new ApiSuccess<>(
                HttpStatus.OK,
                "berhasil mengambil laporan parkir liar dengan id "+idReportParking,
                List.of(data), null);
        return buildResponseEntity(apiSuccess, HttpStatus.OK);
    }


    private <T> ResponseEntity<ApiSuccess<T>> buildResponseEntity(ApiSuccess<T> apiSuccess, HttpStatus status) {
        return new ResponseEntity<>(apiSuccess, status);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
