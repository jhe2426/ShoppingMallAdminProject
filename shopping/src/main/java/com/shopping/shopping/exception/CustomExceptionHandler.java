package com.shopping.shopping.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shopping.shopping.common.constant.ResponseMessage;
import com.shopping.shopping.dto.response.ResponseDto;

@RestControllerAdvice
public class CustomExceptionHandler {
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return ResponseMessage.VAILDATION_FAILED;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseMessage.VAILDATION_FAILED;
    }

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ResponseDto> handleBindException(org.springframework.validation.BindException exception) {
        return ResponseMessage.VAILDATION_FAILED;
    }
}
