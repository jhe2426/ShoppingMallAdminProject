package com.shopping.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopping.entity.CategoryDetailEntity;
import com.shopping.shopping.entity.CategoryTypeEntity;

public interface CategoryDetailRepository extends JpaRepository<CategoryDetailEntity,Integer> {
    public List<CategoryDetailEntity> findByCategoryTypeEntity(CategoryTypeEntity categoryTypeEntity);
    public CategoryDetailEntity findByCategoryDetailNumber(int categoryDetailNumber);
}
