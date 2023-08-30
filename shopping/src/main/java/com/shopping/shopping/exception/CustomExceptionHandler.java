package com.shopping.shopping.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shopping.common.constant.ResponseMessage;
import com.shopping.shopping.dto.response.ResponseDto;

@RestController
public class CustomExceptionHandler {
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDto> HttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        return ResponseMessage.VAILDATION_FAILED;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> HandlerMethodArgumentNotValidExceptio(MethodArgumentNotValidException exception) {
        return ResponseMessage.VAILDATION_FAILED;
    }
}
