package com.crew92.doordie.member.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.crew92.doordie.member.api.exception.ErrorResponse.of;
import static com.crew92.doordie.member.api.exception.GeneralErrorType.INPUT_VALUE_MISMATCH;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("MethodArgumentNotValidException caused !! - path: {}, message: {} ", request.getServletPath(), e.getMessage(), e);
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        final ErrorResponse response = of(request.getServletPath(), fieldErrors.get(0).getDefaultMessage(), e.getBindingResult());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> bindException(BindException e) {
        final ErrorResponse response = of(e.getNestedPath(), e.getMessage(), e.getBindingResult());
        log.error("BindException caused !! - path: {}, binding fail count: {}, message: {}", e.getNestedPath(), e.getErrorCount(), e.getMessage(), e);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        final ErrorResponse response = of(INPUT_VALUE_MISMATCH);
        log.error("MethodArgumentTypeMismatchException caused !! - message: {}", e.getMessage(), e);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
