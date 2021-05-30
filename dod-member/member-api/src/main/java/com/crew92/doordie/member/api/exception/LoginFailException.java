package com.crew92.doordie.member.api.exception;

public class LoginFailException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "로그인에 실패하였습니다. 이메일, 비밀번호를 다시 확인해주세요.";

    public LoginFailException() {
        super(DEFAULT_MESSAGE);
    }

    public LoginFailException(String message) {
        super(message);
    }

}
