package com.crew92.doordie.member.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<FieldError> errors;

    public static ErrorResponse of(GeneralErrorType error) {
        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(error.getStatus().value());
        response.setError(error.getStatus().name());
        response.setMessage(error.getMessage());

        return response;
    }
    public static ErrorResponse of(String path, GeneralErrorType error) {
        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(error.getStatus().value());
        response.setError(error.getStatus().name());
        response.setMessage(error.getMessage());
        response.setPath(path);

        return response;
    }
    public static ErrorResponse of(HttpStatus status, String message) {
        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(status.value());
        response.setError(status.name());
        response.setMessage(message);

        return response;
    }
    public static ErrorResponse of(String path, String message, BindingResult bindingResult) {
        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setError(HttpStatus.BAD_REQUEST.name());
        response.setMessage(message);
        response.setPath(path);
        response.setErrors(bindingResult.getFieldErrors());

        return response;
    }
    public static ErrorResponse of(GeneralErrorType errorType, BindingResult bindingResult) {
        ErrorResponse response = new ErrorResponse();
        response.setTimestamp(LocalDateTime.now());
        response.setStatus(errorType.getStatus().value());
        response.setError(errorType.getStatus().name());
        response.setMessage(errorType.getMessage());
        response.setErrors(bindingResult.getFieldErrors());

        return response;
    }

}
