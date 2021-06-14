package com.crew92.doordie.member.api.exception;

public class JoinFailException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "회원가입에 실패하였습니다.";

    public JoinFailException() {
        super(DEFAULT_MESSAGE);
    }

    public JoinFailException(String message) {
        super(message);
    }

}
