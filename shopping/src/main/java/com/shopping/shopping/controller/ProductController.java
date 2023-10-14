package com.shopping.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.shopping.common.constant.RequestPattern;
import com.shopping.shopping.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(RequestPattern.ADMIN_PRODCUT_API)
public class ProductController {

    private final CategoryService categoryService;

    private final String  GET_PRODUCT_REGISTER_PAGE = "";

    @GetMapping(GET_PRODUCT_REGISTER_PAGE)
    public String getProductPage(Model model) {
        model.addAttribute("categoryList", categoryService.getCateogryList());
        return "register_goods";
    }
}
