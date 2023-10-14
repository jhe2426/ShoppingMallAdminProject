package com.shopping.shopping.dto.request;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostProductRequestDto {
    @NotNull
    private Integer categoryDetailNumber;

    @NotNull
    private Integer price;

    @NotNull
    private MultipartFile image;
}
