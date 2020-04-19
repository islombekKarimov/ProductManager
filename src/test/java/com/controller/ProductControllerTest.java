package com.controller;

import com.data.TestDataProvider;
import com.product.controller.ProductController;
import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.util.TestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by Islombek Karimov on 22.03.2020.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    private ProductRepository productRepository;

    private ProductController productController;

    @Before
    public void setUp() {
        productController = new ProductController();
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testProductHomeView() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(view().name("index"));
    }

    @Test
    public void testCreateProduct() throws Exception {
        Product product = TestDataProvider.createProduct();
        mockMvc.perform(post("/save/{product}", product).contentType(APPLICATION_JSON))
                .andDo(print())

//                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(status().isOk());


    }


//    mockMvc.perform(get("/index").contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(content().contentTypeCompatibleWith("application/json"))
//            .andExpect(jsonPath("$.greeting").value("Hello World"));



}