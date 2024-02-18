package com.mrizkisaputra.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Data
public class ApiError {
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-YYYY hh:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private String debugMessage;

    private List<ApiSubError> subErrors;

    public ApiError() {
        this.timestamp = LocalDateTime.now(ZoneId.systemDefault());
    }

    public ApiError(String status) {
        this();
        this.status = status;
    }

    public ApiError(String status, String message) {
        this(status);
        this.message = message;
    }

    public ApiError(String status, String message, Throwable debugMessage) {
        this(status, message);
        this.debugMessage = debugMessage.getLocalizedMessage();
    }
}
