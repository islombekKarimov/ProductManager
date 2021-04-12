package com.controller;

import com.data.TestDataProvider;
import com.product.ProductManagerApplication;
import com.product.controller.UserController;
import com.product.service.user.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** Created by Islombek Karimov on 21.06.2020. */
@SpringBootTest(
    classes = ProductManagerApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
  private static final long userId = 1;

  private MockMvc mockMvc;

  @Mock private UserService userService;

  @Before
  public void setUp() {
    UserController userController = new UserController();
    userController.setUserService(userService);
    mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
  }

  @Test
  public void test_create() throws Exception {
    mockMvc
        .perform(
            post("/api/user/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestDataProvider.mapToJson(TestDataProvider.createUserDTO())))
        .andExpect(status().isOk());
  }

  @Test
  public void test_update() throws Exception {
    mockMvc
        .perform(
            post("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(TestDataProvider.mapToJson(TestDataProvider.createUserDTO())))
        .andExpect(status().isOk());
  }

  @Test
  public void test_delete() throws Exception {
    mockMvc
        .perform(get("/api/user/delete/{id}", userId).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void test_get() throws Exception {
    mockMvc
        .perform(get("/api/user/get/{id}", userId).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  // TODO check controller
  //  @Test
  //  public void test_product_by_user() throws Exception {
  //    mockMvc
  //        .perform(post("/user-products/{id}", userId).contentType(MediaType.APPLICATION_JSON))
  //        .andExpect(status().isOk());
  //  }

  // TODO change controller method
  //  @Test
  //  public void testGetList() throws Exception {
  //    mockMvc
  //        .perform(
  //            post("/api/user/get-list")
  //                .param("page", "1")
  //                .param("size", "30")
  //                .contentType(MediaType.APPLICATION_JSON))
  //        .andExpect(status().isOk());
  //  }

}
