package com.ecommerce.common.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {
    private int statusCode;
    private String message;
    private String errorCode;
    private T data;
    private Map<String, String> errors;

    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.<T>builder()
                .statusCode(200)
                .message("Success")
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> success(String message, T data) {
        return BaseResponse.<T>builder()
                .statusCode(200)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> BaseResponse<T> error(String message, String errorCode) {
        return BaseResponse.<T>builder()
                .statusCode(400)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public static <T> BaseResponse<T> error(int statusCode, String message, String errorCode) {
        return BaseResponse.<T>builder()
                .statusCode(statusCode)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public static <T> BaseResponse<T> validationError(String message, Map<String, String> errors) {
        return BaseResponse.<T>builder()
                .statusCode(400)
                .message(message)
                .errorCode("VALIDATION_ERROR")
                .errors(errors)
                .build();
    }
}
