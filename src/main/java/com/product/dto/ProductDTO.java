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

  public ProductDTO() {}

  public static ProductDTO of() {
    return new ProductDTO();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getMadeIn() {
    return madeIn;
  }

  public void setMadeIn(String madeIn) {
    this.madeIn = madeIn;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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
