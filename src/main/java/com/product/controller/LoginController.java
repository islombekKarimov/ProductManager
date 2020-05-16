package com.product.controller;

import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Islombek Karimov on 08.05.2020.
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }



}
