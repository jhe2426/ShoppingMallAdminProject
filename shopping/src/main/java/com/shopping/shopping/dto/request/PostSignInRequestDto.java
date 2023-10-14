package com.shopping.shopping.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSignInRequestDto {
    
    @NotBlank
    private String adminId;

    @NotBlank
    private String adminPassword;
}
