package com.example.jwt.exception;

import com.example.jwt.constant.AuthErrorCode;
import com.example.jwt.constant.UserErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRestApiException extends RuntimeException {
    private int code;
    private String message;

    public UserRestApiException(UserErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
    public UserRestApiException(AuthErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
    public String getResponseMessage() {
        return this.message;
    }
}
