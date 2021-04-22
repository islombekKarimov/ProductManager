package com.product.controller;

import com.product.dto.UserDTO;
import com.product.security.jwt.JwtTokenProvider;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** Created by Islombek Karimov on 08.05.2020. */
@RestController
public class AuthController {

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  private UserService userService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/auth")
  public ResponseEntity<Object> auth(@RequestBody UserDTO dto) {
    UserDTO userDTO = userService.findUserByLoginAndPassword(dto.getLogin(), dto.getPassword());
    String token = jwtTokenProvider.generateToken(userDTO.getLogin());
    return ResponseEntity.ok(token);
  }
}
