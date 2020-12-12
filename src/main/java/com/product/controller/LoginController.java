package com.product.controller;

import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Islombek Karimov on 08.05.2020.
 */
@RestController
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

//    @PostMapping("/create")
//    public ResponseEntity create(@RequestBody ProductDTO productDTO) {
//        productService.create(productDTO);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }

//    @PostMapping("/update")
//    public ResponseEntity update(@RequestBody ProductDTO productDTO) {
//        productService.update(productDTO);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }

//    @PostMapping("/delete/{id}")
//    public ResponseEntity delete(@PathVariable(name = "id") Long id) {
//        productService.delete(id);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }

//    @PostMapping("/get/{id}")
//    public ResponseEntity get(@PathVariable(name = "id") Long id) {
//        productService.get(id);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }


}
