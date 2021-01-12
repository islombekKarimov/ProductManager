package com.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.dto.ProductDTO;
import com.product.dto.UserDTO;
import com.product.entity.Product;
import com.product.entity.User;

/** Created by Islombek Karimov on 22.03.2020. */
public class TestDataProvider {
  private static final long productId = 1;
  private static final long userId = 1;

  public static Product createProduct() {
    User user = new User();
    user.setId(userId);
    return Product.of()
        .setName("NAME")
        .setBrand("BRAND")
        .setMadeIn("MADE_IN")
        .setPrice(1000.0)
        .setUser(user);
  }

  public static ProductDTO createProductDTO() {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(userId);
    return ProductDTO.of()
        .setName("NAME")
        .setBrand("BRAND")
        .setMadeIn("MADE_IN")
        .setPrice(1000.0)
        .setUserDTO(userDTO);
  }

  public static User createUser() {
    return User.of().setName("NAME").setLogin("LOGIN").setPassword("PASSWORD");
  }

  public static UserDTO createUserDTO() {
    return UserDTO.of().setName("NAME").setLogin("LOGIN").setPassword("PASSWORD");
  }

  public static String mapToJson(Object obj) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(obj);
  }
}
