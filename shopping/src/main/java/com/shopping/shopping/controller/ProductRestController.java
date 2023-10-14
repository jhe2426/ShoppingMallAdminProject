package com.shopping.shopping.controller;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shopping.common.constant.RequestPattern;
import com.shopping.shopping.dto.request.PostProductRequestDto;
import com.shopping.shopping.dto.response.ResponseDto;
import com.shopping.shopping.service.ProductService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping(RequestPattern.ADMIN_PRODCUT_API)
public class ProductRestController {

    private final ProductService productService;

    private final String  POST_PRODUCT= "register";

    @PostMapping(POST_PRODUCT)
    public ResponseEntity<ResponseDto> postProduct(
        @Valid @ModelAttribute PostProductRequestDto request
    ) {
        ResponseEntity<ResponseDto> response = productService.postProduct(request);
        return response;
    }
}
