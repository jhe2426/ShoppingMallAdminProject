package com.shopping.shopping.dto.response;

import com.shopping.shopping.entity.CategoryDetailEntity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CategoryDetailDto {
   private int categoryTypeNumber;
   private int categoryDetailNumber;
   private String categoryDetail;

   public CategoryDetailDto(CategoryDetailEntity categoryDetailEntity) {
      this.categoryTypeNumber = categoryDetailEntity.getCategoryTypeEntity().getCategoryTypeNumber();
      this.categoryDetailNumber = categoryDetailEntity.getCategoryDetailNumber();
      this.categoryDetail = categoryDetailEntity.getCategoryDetail();
   }
}
