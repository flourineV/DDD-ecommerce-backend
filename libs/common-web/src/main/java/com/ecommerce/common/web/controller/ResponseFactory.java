package com.ecommerce.common.web.controller;

import com.ecommerce.common.web.response.*;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {

    public <T> ResponseEntity<BaseResponse<T>> success(String message, T data) {
        return ResponseEntity.ok(BaseResponse.success(message, data));
    }

    public <T> ResponseEntity<BaseResponse<T>> created(String message, T data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BaseResponse.<T>builder()
                        .statusCode(201)
                        .message(message)
                        .data(data)
                        .build());
    }

    public <T> ResponseEntity<BaseResponse<T>> error(String message, String errorCode) {
        return ResponseEntity.badRequest().body(BaseResponse.error(message, errorCode));
    }

    public <T> ResponseEntity<BaseResponse<T>> error(HttpStatus status, String message, String errorCode) {
        return ResponseEntity.status(status).body(BaseResponse.error(status.value(), message, errorCode));
    }

    public <T> ResponseEntity<BaseResponse<T>> validationError(String message, Map<String, String> errors) {
        return ResponseEntity.badRequest().body(BaseResponse.validationError(message, errors));
    }

    public <T> ResponseEntity<PageResponse<T>> page(String message, List<T> data, int page, int limit, long total) {
        return ResponseEntity.ok(PageResponse.success(data, page, limit, total));
    }

    public ResponseEntity<Void> noContent() {
        return ResponseEntity.noContent().build();
    }

    public <T> ResponseEntity<BaseResponse<T>> successNoData(String message) {
        return ResponseEntity.ok(BaseResponse.<T>builder()
                .statusCode(200)
                .message(message)
                .build());
    }

    public <T> ResponseEntity<BaseResponse<T>> notFound(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(BaseResponse.error(404, message, "NOT_FOUND"));
    }

    public <T> ResponseEntity<BaseResponse<T>> unauthorized(String message) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(BaseResponse.error(401, message, "UNAUTHORIZED"));
    }

    public <T> ResponseEntity<BaseResponse<T>> forbidden(String message) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(BaseResponse.error(403, message, "FORBIDDEN"));
    }

    public <T> ResponseEntity<BaseResponse<T>> conflict(String message) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(BaseResponse.error(409, message, "CONFLICT"));
    }

    public <T> ResponseEntity<BaseResponse<T>> internalError(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(BaseResponse.error(500, message, "INTERNAL_ERROR"));
    }

    public <T> ResponseEntity<BaseResponse<T>> customStatus(HttpStatus status, String message, T data) {
        return ResponseEntity.status(status).body(
                BaseResponse.<T>builder()
                        .statusCode(status.value())
                        .message(message)
                        .data(data)
                        .build());
    }

    public <T> ResponseEntity<BaseResponse<T>> customError(HttpStatus status, String message, String errorCode) {
        return ResponseEntity.status(status).body(
                BaseResponse.error(status.value(), message, errorCode));
    }
}
