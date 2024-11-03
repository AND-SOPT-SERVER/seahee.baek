package org.sopt.diary.exception;

import org.springframework.http.HttpStatus;

public class EmailFormatException extends RuntimeException {
  private final int code = 40000;
  private final String message = "이메일 형식이 올바르지 않습니다.";

  public EmailFormatException() {

  }

  public int getCode() {
    return code;
  }

  public String getMessage() {return message;}
}
