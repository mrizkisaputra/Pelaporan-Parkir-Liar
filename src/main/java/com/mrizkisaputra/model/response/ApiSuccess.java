package com.mrizkisaputra.model.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class ApiSuccess<T> {
    private HttpStatus status;

    private String message;

    private List<T> data;

    private PagingResponse paging;

    public ApiSuccess(HttpStatus status) {
        this.status = status;
    }

    public ApiSuccess(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

    public ApiSuccess(HttpStatus status, String message, List<T> data) {
        this(status, message);
        this.data = data;
    }

    public ApiSuccess(HttpStatus status, String message, List<T> data, PagingResponse paging) {
        this(status, message, data);
        this.paging = paging;
    }
}
