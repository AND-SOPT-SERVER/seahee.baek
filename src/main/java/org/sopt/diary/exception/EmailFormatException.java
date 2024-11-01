package org.sopt.diary.exception;

import org.springframework.http.HttpStatus;

public class EmailFormatException extends RuntimeException {
  private final int code = 40000;
  private final HttpStatus status = HttpStatus.BAD_REQUEST;

  public EmailFormatException() {
    super("이메일 형식이 올바르지 않습니다.");
  }

  public int getCode() {
    return code;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
