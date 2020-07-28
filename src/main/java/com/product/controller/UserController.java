package com.product.controller;

import static com.product.constant.ApiPath.API_USER;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** Created by Islombek Karimov on 16.05.2020. */
@RestController
@RequestMapping(value = API_USER)
public class UserController {

  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }


}
