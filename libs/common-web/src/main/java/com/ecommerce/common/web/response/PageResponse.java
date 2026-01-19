package com.ecommerce.common.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResponse<T> {
    private int statusCode;
    private String message;
    private List<T> data;
    private PagingResponse paging;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PagingResponse {
        private int page;
        private int limit;
        private long total;
        private int totalPages;
    }

    public static <T> PageResponse<T> success(List<T> data, int page, int limit, long total) {
        int totalPages = (int) Math.ceil((double) total / limit);
        return PageResponse.<T>builder()
                .statusCode(200)
                .message("Success")
                .data(data)
                .paging(PagingResponse.builder()
                        .page(page)
                        .limit(limit)
                        .total(total)
                        .totalPages(totalPages)
                        .build())
                .build();
    }
}
