package com.shopping.shopping.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.shopping.common.constant.ResponseMessage;
import com.shopping.shopping.dto.response.CategoryDto;
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
    public List<CategoryDto> getCateogryList() {

        List<CategoryDto> categoryDtoList = new ArrayList<>();

        try {
            List<CategoryTypeEntity> categoryTypeList = categoryTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "categoryTypeNumber"));

            
            

            for(CategoryTypeEntity categoryTypeEntity: categoryTypeList) {
                List<CategoryDetailEntity> categoryDetailList = categoryDetailRepository.findByCategoryTypeEntity(categoryTypeEntity);
                CategoryDto categoryDto = new CategoryDto(categoryTypeEntity, categoryDetailList);
                categoryDtoList.add(categoryDto);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return categoryDtoList;
    }
    
}
