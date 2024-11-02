package org.sopt.diary.exception;

import org.springframework.http.HttpStatus;

public class IncorrectPasswordException extends RuntimeException {
    private final int code = 40100;
    private final String message = "비밀번호가 잘못되었습니다.";

    public IncorrectPasswordException() {
    }

    public int getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }
}