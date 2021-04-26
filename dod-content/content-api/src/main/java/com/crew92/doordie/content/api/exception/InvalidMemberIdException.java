package com.crew92.doordie.content.api.exception;

public class InvalidMemberIdException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "회원정보를 찾을 수 없습니다.";

    public InvalidMemberIdException() {
        super(DEFAULT_MESSAGE);
    }

}
