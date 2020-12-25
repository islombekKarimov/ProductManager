package com.product.controller;

//import static com.product.constant.ApiPath.API_USER;

import com.product.dto.UserDTO;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Islombek Karimov on 16.05.2020.
 */

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity update(@RequestBody UserDTO userDTO) {
        userService.update(userDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<Object> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PostMapping("/get-list")
    public Page<UserDTO> getList(@PageableDefault(size = 30, value = 0) Pageable pageable) {
        return userService.findAll(pageable);
    }

    @PostMapping("/user/products")
    public Page<UserDTO> getProductList(@PageableDefault(size = 30, value = 0) Pageable pageable){
        return null;
    }
}

