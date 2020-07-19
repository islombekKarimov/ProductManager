package com.product.dto;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;

/** Created by Islombek Karimov on 05.07.2020. */
public class ProductDTO extends BaseDTO {

  @NotEmpty(message = "Name can not be null!")
  private String name;

  @NotEmpty(message = "Brand can not be null!")
  private String brand;

  @NotEmpty(message = "Made in can not be null!")
  private String madeIn;

  @NotEmpty(message = "Price can not be null!")
  private double price;

  private UserDTO userDTO;

  public ProductDTO() {}

  public static ProductDTO of() {
    return new ProductDTO();
  }

  public String getName() {
    return name;
  }

  public ProductDTO setName(String name) {
    this.name = name;
    return this;
  }

  public String getBrand() {
    return brand;
  }

  public ProductDTO setBrand(String brand) {
    this.brand = brand;
    return this;
  }

  public String getMadeIn() {
    return madeIn;
  }

  public ProductDTO setMadeIn(String madeIn) {
    this.madeIn = madeIn;
    return this;
  }

  public double getPrice() {
    return price;
  }

  public ProductDTO setPrice(double price) {
    this.price = price;
    return this;
  }

  public UserDTO getUserDTO() {
    return userDTO;
  }

  public ProductDTO setUserDTO(UserDTO userDTO) {
    this.userDTO = userDTO;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDTO dto = (ProductDTO) o;
    return Objects.equals(getId(), dto.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
