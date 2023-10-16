package com.shopping.shopping.service.implement;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping.shopping.entity.OrdersEntity;
import com.shopping.shopping.repository.OrdersRepository;
import com.shopping.shopping.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImplement implements PaymentService{
    private final OrdersRepository ordersRepository;

    @Override
    public Page<OrdersEntity> getPaymentList(Pageable pageable) {
        Page<OrdersEntity> body = null;

        try {
            body = ordersRepository.findAll(pageable);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return body;
    }
}
