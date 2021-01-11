package com.service.product;

import com.product.ProductManagerApplication;
import com.product.dto.ProductDTO;
import com.product.dto.UserDTO;
import com.product.entity.Product;
import com.product.entity.User;
import com.product.repository.ProductRepository;
import com.product.service.product.ProductService;
import com.product.service.product.impl.ProductServiceImpl;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

/** Created by Islombek Karimov on 22.06.2020. */
@SpringBootTest(
    classes = ProductManagerApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

  private static final long productId = 1;
  private static final long userId = 1;

  @Mock private ProductRepository productRepository;

  @InjectMocks private ProductService productService = new ProductServiceImpl();

  private ProductDTO createProductDTO() {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setId(productId);
    productDTO.setName("NAME");
    productDTO.setBrand("BRAND");
    productDTO.setMadeIn("MADE_IN");
    productDTO.setPrice(1000.0);
    UserDTO userDTO = new UserDTO();
    userDTO.setId(userId);
    productDTO.setUserDTO(userDTO);
    return productDTO;
  }

  private Product createProduct() {
    Product product = new Product();
    product.setId(productId);
    product.setName("NAME");
    product.setBrand("BRAND");
    product.setMadeIn("MADE_IN");
    product.setPrice(1000.0);
    User user = new User();
    user.setId(userId);
    product.setUser(user);
    return product;
  }
}
