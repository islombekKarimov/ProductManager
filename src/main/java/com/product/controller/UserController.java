package com.product.controller;

import com.product.dto.UserDTO;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.product.constant.ApiPath.API_USER;

/** Created by Islombek Karimov on 16.05.2020. */
@RestController
@RequestMapping(value = API_USER)
public class UserController {

  private UserService userService;
  private ProductService productService;

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/create")
  public ResponseEntity<Object> create(@RequestBody UserDTO userDTO) {
    try {
      userService.create(userDTO);
      return ResponseEntity.ok(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/update")
  public ResponseEntity<Object> update(@RequestBody UserDTO userDTO) {
    try {
      userService.update(userDTO);
      return ResponseEntity.ok(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
    try {
      userService.delete(id);
      return ResponseEntity.ok(HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<Object> get(@PathVariable(name = "id") Long id) {
    try {
      return ResponseEntity.ok(userService.get(id));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/get-list")
  public ResponseEntity<Object> getList(@PageableDefault(size = 30, value = 0) Pageable pageable) {
    try {
      return ResponseEntity.ok(userService.findAll(pageable));

    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/user-products")
  public ResponseEntity<Object> getProductList(@RequestParam(name = "id") Long id) {
    try {
      return ResponseEntity.ok(productService.getProductByUserList(id));
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
