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

    public static final ResponseEntity<ResponseDto> FILE_UPLOAD_ERROR
    = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("FUE", "File Upload Error"));

    public static final ResponseEntity<ResponseDto> DATABASE_ERROR
    = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto("DE", "Database Error"));
}
