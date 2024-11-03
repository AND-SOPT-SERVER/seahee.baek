package org.sopt.diary.exception;

public class UnauthorizedException extends RuntimeException {
    private final int code = 40300;
    private final String message = "권한이 없습니다.";

    public UnauthorizedException() {

    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
