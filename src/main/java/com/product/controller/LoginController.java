package com.product.controller;

import com.product.entity.User;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Islombek Karimov on 08.05.2020.
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping(value = {"/", "/login"})
    public String loginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }


    @PostMapping(value = {"/user_login"})
    public ModelAndView checkUserByLogin(@ModelAttribute(name = "user") User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.getUserByLogin(user.getLogin());
        if (userList.size() == 0) {
            bindingResult.rejectValue("login", "error.login", "You don't register");
            modelAndView.setViewName("login");
        }
        if (userList.size() > 0) {
            for (User listUser : userList) {
                if (listUser.getLogin().equals(user.getLogin()) && listUser.getPassword().equals(user.getPassword())) {
//                    int userId = listUser.getId();
//                    modelAndView.setViewName("redirect:/product_list_by_userId/" + userId);
                } else {
                    bindingResult.rejectValue("password", "error.password", "Your Login or Password incorrect");
                    modelAndView.setViewName("login");
                }
            }
        }
        return modelAndView;
    }


}
