package com.crew92.doordie.content.api.exception;

public class TodoNotFoundException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "할일 조회에 실패했습니다.";

    public TodoNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}
