package com.controller;

import com.data.TestDataProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.controller.UserController;
import com.product.dto.UserDTO;
import com.product.entity.User;
import com.product.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.Assert.assertEquals;


/**
 * Created by Islombek Karimov on 21.06.2020.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private UserController userController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        userController = new UserController();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testUserCreate() throws Exception {
//        User user = TestDataProvider.createUser();
//        mockMvc.perform(post("/save_user")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .sessionAttr("user", user))
//                .andExpect(status().isOk())
//                .andExpect(view().name("registration"));
    }

    @Test
    public void testCreate() throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1l);
        userDTO.setName("USER");
        userDTO.setLogin("LOGIN");
        userDTO.setPassword("PASSWORD");
        String jsonObj = mapToJson(userDTO);
        mockMvc.perform(post("/api/user/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonObj))
                .andExpect(status().isOk());
//        int status = result.getResponse().getStatus();
//        assertEquals(200, status);

    }

    @Test
    public void testUserList() throws Exception {
        mockMvc.perform(post("/api/user/list")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

    }



    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }


}
