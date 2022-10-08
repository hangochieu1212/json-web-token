package com.example.jwt.exception;

import com.example.jwt.constant.UserErrorCode;
import com.example.jwt.controller.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@Service
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(UserRestApiException.class)
    public ResponseEntity<BaseResponse> handleException(UserRestApiException ex) {
        return new ResponseEntity<>(new BaseResponse(ex.getCode(), ex.getMessage()), HttpStatus.OK);
    }
    @ExceptionHandler(IOException.class)
    public ResponseEntity<BaseResponse> handleIOException(IOException ex) {
        return new ResponseEntity<>(new BaseResponse((UserErrorCode.INTERNAL_ERROR)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
