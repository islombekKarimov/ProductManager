package com.product.controller;

//import static com.product.constant.ApiPath.API_USER;

import com.product.dto.UserDTO;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/** Created by Islombek Karimov on 16.05.2020. */
@RestController
@RequestMapping(value ="/api/user")
public class UserController {

  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/create")
  public ResponseEntity create(@RequestBody  UserDTO userDTO) {
     userService.create(userDTO);
    return ResponseEntity.ok(HttpStatus.OK);
  }

}
