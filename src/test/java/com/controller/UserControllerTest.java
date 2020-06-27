package com.controller;

import com.data.TestDataProvider;
import com.product.controller.UserController;
import com.product.entity.User;
import com.product.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Islombek Karimov on 21.06.2020.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
    private UserController userController;
    private UserRepository userRepository;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        userController = new UserController();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testRegistrationPage() throws Exception {
        mockMvc.perform(get("/registration_page"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));
    }

    @Test
    public void testUserCreate() throws Exception {
        User user = TestDataProvider.createUser();
        mockMvc.perform(post("/save_user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .sessionAttr("user", user))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));
    }


}
