package com.shopping.shopping.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shopping.shopping.dto.response.CategoryResponseDto;
import com.shopping.shopping.entity.CategoryDetailEntity;
import com.shopping.shopping.entity.CategoryTypeEntity;
import com.shopping.shopping.repository.CategoryDetailRepository;
import com.shopping.shopping.repository.CategoryTypeRepository;
import com.shopping.shopping.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImplement implements CategoryService {

    private final CategoryTypeRepository categoryTypeRepository;
    private final CategoryDetailRepository categoryDetailRepository;

    @Override
    public List<CategoryResponseDto> getCateogryList() {

        List<CategoryResponseDto> categoryDtoList = new ArrayList<>();

        try {
            List<CategoryTypeEntity> categoryTypeList = categoryTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryTypeNumber"));

            
            

            for(CategoryTypeEntity categoryTypeEntity: categoryTypeList) {
                List<CategoryDetailEntity> categoryDetailList = categoryDetailRepository.findByCategoryTypeEntity(categoryTypeEntity);
                CategoryResponseDto categoryDto = new CategoryResponseDto(categoryTypeEntity, categoryDetailList);
                categoryDtoList.add(categoryDto);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return categoryDtoList;
    }
    
}
