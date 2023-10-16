package com.shopping.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopping.entity.FavoriteEntity;
import com.shopping.shopping.entity.ProductEntity;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity,Integer> {
    
    public List<FavoriteEntity> findByProductEntity(ProductEntity productEntity);

}
