package com.shopping.shopping.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shopping.shopping.entity.OrdersEntity;

public interface PaymentService {
    public Page<OrdersEntity> getPaymentList(Pageable pageable);
}
