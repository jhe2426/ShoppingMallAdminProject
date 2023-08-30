package com.shopping.shopping.service;

import org.springframework.http.ResponseEntity;

import com.shopping.shopping.dto.request.PostSignInRequestDto;
import com.shopping.shopping.dto.response.ResponseDto;

public interface MainPageService {
    public ResponseEntity<ResponseDto> signIn(PostSignInRequestDto dto);
}
