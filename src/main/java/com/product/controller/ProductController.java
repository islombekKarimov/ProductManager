package com.product.controller;

import com.product.entity.Product;
import com.product.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/product_list/{userId}")
    public String viewHomePage(Model model) {
        List<Product> getProductList = productService.getProductList();
        model.addAttribute("productList", getProductList);
        return "index";
    }

    @RequestMapping("/test")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }


    @PostMapping(value = "/save/{userId}")
    public  String saveProduct(@ModelAttribute(name = "product") Product productDTO) {
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

