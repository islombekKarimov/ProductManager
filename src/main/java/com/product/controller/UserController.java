package com.product.controller;

import com.product.entity.User;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Islombek Karimov on 16.05.2020.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;


    @GetMapping(value = {"/registration_page"})
    public String registrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping(value = {"/save_user"})
    public String saveUser(@ModelAttribute(name = "user") User user ){
        System.out.println(user.getName());
        System.out.println(user.getLogin());
        System.out.println(user.getPassword());
        userService.create(user);
    return "redirect:/user_list";
    }

    @RequestMapping(value = {"/user_list"})
    public String userList(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "user.list";
    }



}
