package com.shopping.shopping.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.shopping.common.constant.RequestPattern;
import com.shopping.shopping.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(RequestPattern.ADMIN_PAYMENT_API)
public class PaymentController {

    private final PaymentService paymentService;

    private final String  GET_PAYMENT_PAGE = "";
    
    @GetMapping(GET_PAYMENT_PAGE)
    public String getPaymentPage(Model model, @PageableDefault(size=5, sort="ordersNumber", direction = Direction.DESC) Pageable pageable) {
        model.addAttribute("paymentList", paymentService.getPaymentList(pageable));
        return "user_payment_list";
    }
}
