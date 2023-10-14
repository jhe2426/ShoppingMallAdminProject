package com.shopping.shopping.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.shopping.common.constant.RequestPattern;
import com.shopping.shopping.entity.ProductEntity;
import com.shopping.shopping.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(RequestPattern.ADMIN_MAIN_API)
public class MainPageController {

    private final ProductService productService;

    private final String GET_LOGIN_PAGE = "login";
    private final String GET_MAIN_PAGE = "main";

    @GetMapping(GET_LOGIN_PAGE)
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(GET_MAIN_PAGE) 
    public String getMainPage(Model model,@PageableDefault(size=5,sort = "productNumber", direction = Direction.DESC) Pageable pageable) {
        model.addAttribute("productList",  productService.getProductList(pageable));
        return "main";
    }
}
