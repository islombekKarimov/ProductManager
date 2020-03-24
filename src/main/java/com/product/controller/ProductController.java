package com.product.controller;

import com.product.entity.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> getProductList = productService.getProductList();
        model.addAttribute("productList", getProductList);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
     return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
       productService.saveProduct(product);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable(name="id") int id){
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = productService.getProductById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id){
        productService.delete(id);
        return "redirect:/";
    }


}

