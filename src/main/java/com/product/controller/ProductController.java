package com.product.controller;

import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/** Created by Islombek Karimov on 21.03.2020. */
@RestController
public class ProductController {
  private ProductService productService;
  private UserService userService;

  @Autowired
  public ProductController setProductService(ProductService productService) {
    this.productService = productService;
    return this;
  }

  @Autowired
  public ProductController setUserService(UserService userService) {
    this.userService = userService;
    return this;
  }
}
