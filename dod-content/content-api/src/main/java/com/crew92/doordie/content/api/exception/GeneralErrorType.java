package com.crew92.doordie.content.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum GeneralErrorType {

    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "요청값이 유효하지 않습니다."),
    INPUT_VALUE_MISMATCH(HttpStatus.BAD_REQUEST, "요청값이 유효하지 않습니다."),
    INVALID_METHOD(HttpStatus.BAD_REQUEST, "요청 Method 타입이 잘못되었습니다."),
    ;

    private final HttpStatus status;
    private final String message;

}
