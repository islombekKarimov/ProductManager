package com.product.converter;

import com.product.dto.ProductDTO;
import com.product.dto.UserDTO;
import com.product.entity.Product;
import com.product.entity.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ProductConvertor.
 *
 * @author Islombek Karimov
 * @since 16.07.2020
 */
public class ProductConverter extends Converter<ProductDTO, Product> {

  public ProductConverter() {
    super(ProductConverter::toEntity, ProductConverter::toDTO);
  }

  public static ProductDTO toDTO(Product entity) {
    ProductDTO dto =
        ProductDTO.of()
            .setName(entity.getName())
            .setBrand(entity.getBrand())
            .setMadeIn(entity.getBrand())
            .setPrice(entity.getPrice())
            .setCreatedDate(entity.getCreatedDate());
    User user = entity.getUser();
    if (user != null) {
      UserDTO userDTO = UserDTO.of();
      userDTO.setId(user.getId());
      dto.setUserDTO(userDTO);
    }
    dto.setId(entity.getId());
    return dto;
  }

  public static Product toEntity(ProductDTO dto) {
    Product entity =
        Product.of()
            .setName(dto.getName())
            .setBrand(dto.getBrand())
            .setMadeIn(dto.getMadeIn())
            .setPrice(dto.getPrice())
            .setCreatedDate(dto.getCreatedDate());
    UserDTO userDTO = dto.getUserDTO();
    if (userDTO != null) {
      User user = User.of();
      user.setId(userDTO.getId());
      entity.setUser(user);
    }
    entity.setId(dto.getId());
    return entity;
  }

  public static List<ProductDTO> entityListToDtoList(List<Product> productList) {
    return productList != null
        ? productList.stream().map(ProductConverter::toDTO).collect(Collectors.toList())
        : null;
  }
}
