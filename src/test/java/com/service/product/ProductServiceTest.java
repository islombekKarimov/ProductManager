package com.service.product;

import com.data.TestDataProvider;
import com.product.ProductManagerApplication;
import com.product.dto.ProductDTO;
import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.product.ProductService;
import com.product.service.product.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

  @Test
  public void test_create() {
    ProductDTO productDTO = TestDataProvider.createProductDTO();
    Product product = TestDataProvider.createProduct();
    when(productRepository.save(any())).thenReturn(product);
    ProductDTO result = productService.create(productDTO);
    assertNotNull(result);
    assertEquals(result.getName(), product.getName());
    verify(productRepository, times(1)).save(any());
  }

  @Test
  public void test_update() {
    Product product = TestDataProvider.createProduct();
    product.setId(productId);
    ProductDTO productDTO = TestDataProvider.createProductDTO();
    productDTO.setId(productId);
    Optional<Product> productOptional = Optional.of(product);
    when(productRepository.findById(productId)).thenReturn(productOptional);
    when(productRepository.save(any())).thenReturn(product);
    ProductDTO result = productService.update(productDTO);
    assertNotNull(result);
    assertEquals(result.getId(), product.getId());
    assertEquals(result.getName(), product.getName());
    assertEquals(result.getBrand(), product.getBrand());
    verify(productRepository, times(1)).save(any());
  }

  @Test
  public void test_delete() {
    productService.delete(productId);
    verify(productRepository, times(1)).deleteById(productId);
  }

  @Test
  public void test_getNotFound() {
    when(productRepository.findById(productId)).thenReturn(Optional.empty());
    Assertions.assertThrows(EntityNotFoundException.class, () -> productService.get(productId));
  }

  @Test
  public void test_get() {
    Product product = TestDataProvider.createProduct();
    Optional<Product> productOptional = Optional.of(product);
    when(productRepository.findById(productId)).thenReturn(productOptional);
    ProductDTO result = productService.get(productId);
    assertNotNull(result);
    verify(productRepository, times(1)).findById(productId);
  }

  // TODO find out
  @Test
  public void test_findAll() {}
}
