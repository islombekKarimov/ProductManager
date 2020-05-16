package com.product.controller;

import com.product.entity.User;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Islombek Karimov on 16.05.2020.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;


    @RequestMapping(value = {"registration_page"}, method = RequestMethod.GET)
    public String registrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }




}
