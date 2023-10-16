package com.shopping.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopping.entity.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
    public ProductEntity findByProductNumber(int productNumber);
}
