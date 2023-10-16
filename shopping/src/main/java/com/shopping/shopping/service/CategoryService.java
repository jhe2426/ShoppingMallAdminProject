package com.shopping.shopping.service;

import java.util.List;

import com.shopping.shopping.dto.response.GetCategoryResponseDto;

public interface CategoryService {
    public List<GetCategoryResponseDto> getCateogryList();
}
