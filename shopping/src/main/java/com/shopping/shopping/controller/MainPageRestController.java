package com.shopping.shopping.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shopping.common.constant.RequestPattern;
import com.shopping.shopping.dto.request.PostSignInRequestDto;
import com.shopping.shopping.dto.response.ResponseDto;
import com.shopping.shopping.service.MainPageService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(RequestPattern.ADMIN_MAIN_API)
@RequiredArgsConstructor
public class MainPageRestController {


    private final MainPageService mainPageService;

    private final String POST_LOGIN_IN = "login";

    @PostMapping(POST_LOGIN_IN)
    public ResponseEntity<ResponseDto> signIn (
        @Valid @RequestBody PostSignInRequestDto request
    ) {
        ResponseEntity<ResponseDto> response = mainPageService.signIn(request);
        return response;
    }
}
