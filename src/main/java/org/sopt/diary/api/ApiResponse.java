package org.sopt.diary.api;

public class ApiResponse {
    private int code;
    private String message;
    private Object data;

    public ApiResponse(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
