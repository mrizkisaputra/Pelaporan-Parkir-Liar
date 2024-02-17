package com.mrizkisaputra.model.response;

import lombok.Data;

@Data
public class PagingResponse {
    private Long totalElement;

    private Integer totalPages;

    private Integer size;

    public PagingResponse(Long totalElement) {
        this.totalElement = totalElement;
    }

    public PagingResponse(Long totalElement, Integer totalPages) {
        this(totalElement);
        this.totalPages = totalPages;
    }

    public PagingResponse(Long totalElement, Integer totalPages, Integer size) {
        this(totalElement, totalPages);
        this.size = size;
    }
}
