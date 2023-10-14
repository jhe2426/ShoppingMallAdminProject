package com.shopping.shopping.dto.response;

import java.util.ArrayList;
import java.util.List;

import com.shopping.shopping.entity.CategoryDetailEntity;
import com.shopping.shopping.entity.CategoryTypeEntity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CategoryResponseDto {
    private int categoryTypeNumber;
    private String categoryType;
    private List<CategoryDetailDto> categoryDetailDtoList;

    public CategoryResponseDto(CategoryTypeEntity categoryTypeEntity, List<CategoryDetailEntity> categoryDetailList) {
        List<CategoryDetailDto> categoryDetailDtoList = new ArrayList<>();

        for(CategoryDetailEntity categoryDetailEntity: categoryDetailList) {
            CategoryDetailDto categoryDetailDto = new CategoryDetailDto(categoryDetailEntity);
            categoryDetailDtoList.add(categoryDetailDto);
        }

        this.categoryTypeNumber = categoryTypeEntity.getCategoryTypeNumber();
        this.categoryType = categoryTypeEntity.getCategoryType();
        this.categoryDetailDtoList = categoryDetailDtoList;
    }
}
