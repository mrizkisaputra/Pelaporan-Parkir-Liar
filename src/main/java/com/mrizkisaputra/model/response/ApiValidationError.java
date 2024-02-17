package com.mrizkisaputra.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = true)
@Builder
public class ApiValidationError extends ApiSubError {
    private String object;

    private String field;

    private Object rejectedValue;

    private String message;
}


