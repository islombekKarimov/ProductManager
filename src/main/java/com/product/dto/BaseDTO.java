package com.product.dto;

/**
 * BaseDTO.
 *
 * @author Islombek Karimov
 * @since 16.07.2020
 */
public class BaseDTO {
  private Long id;

  public Long getId() {
    return id;
  }

  public BaseDTO setId(Long id) {
    this.id = id;
    return this;
  }
}