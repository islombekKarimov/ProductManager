package com.controller;

import com.data.TestDataProvider;
import com.product.ProductManagerApplication;
import com.product.controller.ProductController;
import com.product.service.product.ProductService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/** Created by Islombek Karimov on 22.03.2020. */
@SpringBootTest(
    classes = ProductManagerApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
  private static final long productId = 1;
  private static final long userId = 1;

  private MockMvc mockMvc;

  @Mock private ProductService productService;

  private ProductController productController;

  @Before
  public void setUp() {
    productController = new ProductController();
    productController.setProductService(productService);
    mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
  }

  @Test
  public void test_create() throws Exception {
    mockMvc
        .perform(
            post("/api/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestDataProvider.mapToJson(TestDataProvider.createProduct())))
        .andExpect(status().isOk());
  }

  @Test
  public void test_update() throws Exception {
    mockMvc
        .perform(
            post("/api/product/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestDataProvider.mapToJson(TestDataProvider.createProduct())))
        .andExpect(status().isOk());
  }

  @Test
  public void test_delete() throws Exception {
    mockMvc
        .perform(
            post("/api/product/delete/{id}", productId).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void test_get() throws Exception {
    mockMvc
        .perform(post("/api/product/get/{id}", productId).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}
