package com.product.controller;

import com.product.entity.Product;
import com.product.entity.User;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */
@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @GetMapping(value = {"/product_list_by_userId/{userId}"})
    public String userList(@PathVariable(name = "userId") int userId, Model model) {
        List<Product> productList = productService.getProductListByUserId(userId);
//        User user = userService.findById(userId);
        model.addAttribute("productList", productList);
        model.addAttribute("userId", userId);
        return "user.products";
    }

    @RequestMapping("/test")
    public String homePage() {
        return "index";
    }

    @GetMapping(value = "/new/{userId}")
    public String showNewProduct(@PathVariable(name = "userId") int user, Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }


    @PostMapping(value = "/save/{userId}")
    public String saveProduct(@ModelAttribute(name = "product") Product productDTO) {
        productService.saveProduct(productDTO);
        return "redirect:/product_list";
    }


    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editProduct(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = productService.getProductById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.delete(id);
        return "redirect:/";
    }



}

