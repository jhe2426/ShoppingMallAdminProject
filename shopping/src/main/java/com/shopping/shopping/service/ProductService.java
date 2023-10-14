package com.shopping.shopping.service;

import org.springframework.http.ResponseEntity;

import com.shopping.shopping.dto.request.PostProductRequestDto;
import com.shopping.shopping.dto.response.ResponseDto;

public interface ProductService {
    public ResponseEntity<ResponseDto> postProduct(PostProductRequestDto dto);
}
