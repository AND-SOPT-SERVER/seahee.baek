package org.sopt.diary.exception;

import org.springframework.http.HttpStatus;

public class DiaryLengthException extends RuntimeException{

    private final int code;
    private final String message;

    public DiaryLengthException(boolean isTitle) {
        if (isTitle) {
            this.code = 40001;
            this.message = "제목의 글자 길이가 초과되었습니다.";
        } else {
            this.code = 40000;
            this.message = "본문의 글자 길이가 초과되었습니다.";
        }
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
