package com.shopping.shopping.common.constant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.shopping.shopping.dto.response.ResponseDto;

public interface ResponseMessage {
    public static final ResponseEntity<ResponseDto> SUCCESS 
    = ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("SU", "SUCCESS"));

    public static final ResponseEntity<ResponseDto> VAILDATION_FAILED 
    = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("VF", "Request Parameter Validation Failed"));

    public static final ResponseEntity<ResponseDto> SIGN_IN_FAILED 
    = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto("SF", "Sign In Failed"));
}
