package com.shopping.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopping.entity.CategoryTypeEntity;

public interface CategoryTypeRepository extends JpaRepository<CategoryTypeEntity,Integer>{
    
}
