package com.shopping.shopping.service.implement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.shopping.common.constant.ResponseMessage;
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

        String inputAdminId = dto.getAdminId();
        String inputAdminPasword = dto.getAdminPassword();

        if (!adminId.equals(inputAdminId)) return ResponseMessage.SIGN_IN_FAILED;
        
        if (!adminPassword.equals(inputAdminPasword)) return ResponseMessage.SIGN_IN_FAILED;

        return ResponseMessage.SUCCESS;
    }
    
}
