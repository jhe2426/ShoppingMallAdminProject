package com.shopping.shopping.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.shopping.shopping.dto.request.PostProductRequestDto;
import com.shopping.shopping.dto.response.ResponseDto;
import com.shopping.shopping.entity.ProductEntity;

public interface ProductService {
    public ResponseEntity<ResponseDto> postProduct(PostProductRequestDto dto);
    public Page<ProductEntity> getProductList(Pageable pageable);
}
