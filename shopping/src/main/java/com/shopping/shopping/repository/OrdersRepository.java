package com.shopping.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopping.entity.OrdersEntity;

public interface OrdersRepository extends JpaRepository<OrdersEntity,Integer> {
    
}
