package com.shopping.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.shopping.common.constant.RequestPattern;

@Controller
@RequestMapping(RequestPattern.ADMIN_MAIN_API)
public class MainPageController {
    
    private final String GET_LOGIN_PAGE = "login";
    private final String GET_MAIN_PAGE = "main";

    @GetMapping(GET_LOGIN_PAGE)
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(GET_MAIN_PAGE) 
    public String getMainPage() {
        return "index";
    }
}
