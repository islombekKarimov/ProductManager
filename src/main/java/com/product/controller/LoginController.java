package com.product.controller;

import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Islombek Karimov on 08.05.2020.
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

}
