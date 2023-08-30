package com.shopping.shopping.service.implement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.shopping.dto.request.PostSignInRequestDto;
import com.shopping.shopping.dto.response.ResponseDto;
import com.shopping.shopping.service.MainPageService;

@Service
public class MainPageServiceImplement implements MainPageService {

    @Value("${admin.id}")
    String adminId;
    @Value("${admin.password}")
    String adminPassword;

    @Override
    public ResponseEntity<ResponseDto> signIn(PostSignInRequestDto dto) {
        
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("SU", "SUCCESS"));
    }
    
}
