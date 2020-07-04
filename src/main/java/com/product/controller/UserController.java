package com.product.controller;
import com.product.entity.User;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Islombek Karimov on 16.05.2020.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;


    @GetMapping(value = {"/registration_page"})
    public String registrationPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

//    @PostMapping(value = {"/save_user"})
//    public ModelAndView createNewUser(@ModelAttribute(name = "user") User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//         List<User> existUser = userService.getUserByLogin(user.getLogin());
//        if (existUser.size() != 0) {
//            bindingResult.rejectValue("login", "error.login", "There is a User with such Login");
//            modelAndView.setViewName("registration");
//        }
//        else {
//            userService.create(user);
//            modelAndView.setViewName("redirect:/login");
//        }
//        return modelAndView;
//    }

    @PostMapping(value = {"/save_user"})
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user ) {
        return userService.create(user);
    }



    @RequestMapping(value = {"/edit_user/{id}"})
    public ModelAndView editUser(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("user.edit");
        User user = userService.findById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }


    @RequestMapping(value = {"/delete_user/{id}"})
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.delete(id);
        return "redirect:/user_list";
    }


}
