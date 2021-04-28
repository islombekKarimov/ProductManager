package com.product.controller;

import com.product.dto.ProductDTO;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.product.constant.ApiPath.API_PRODUCT;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */
@RestController
@RequestMapping(value = API_PRODUCT)
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
    public ResponseEntity<Object> create(@RequestBody ProductDTO dto) {
        productService.create(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ProductDTO dto) {
        productService.update(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @GetMapping("/get-list")
    public Page<ProductDTO> getList(@PageableDefault(size = 30, value = 0) Pageable pageable) {
       LOGGER.info("Product List: " + productService.findAll(pageable).getContent());
        return productService.findAll(pageable);
    }

}
