package com.shopping.shopping.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSignInRequestDto {
    
    @NotBlank
    private String adminId;

    @NotBlank
    private String adminPassword;
}
