package com.product.controller;

import com.product.dto.ProductDTO;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */
@RestController
public class ProductController {
    private ProductService productService;
    private UserService userService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody ProductDTO dto) {
        productService.create(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody ProductDTO dto) {
        productService.update(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/get/{id}")
    public ResponseEntity get(@PathVariable(name = "id") Long id) {
        productService.get(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
