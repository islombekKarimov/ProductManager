package com.product.controller;
import com.product.dto.UserDTO;
import com.product.entity.User;
import com.product.service.product.ProductService;
import com.product.service.user.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
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
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO ) throws ConstraintViolationException, EntityNotFoundException {
        return userService.create(userDTO);
    }



    @RequestMapping(value = {"/edit_user/{id}"})
    public UserDTO editUser(@PathVariable(name = "id") int id) throws ConstraintViolationException, EntityNotFoundException {
        return userService.findById(id);
    }


    @RequestMapping(value = {"/delete_user/{id}"})
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.delete(id);
        return "redirect:/user_list";
    }


}
