package com.product.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/** Created by Islombek Karimov on 21.03.2020. */
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

  private static final long serialVersionUID = -6291879670469397777L;

  @Column(name = "name", nullable = false)
  @NotNull(message = "product name con't be null")
  private String name;

  @Column(name = "brand", nullable = false)
  @NotNull(message = "product brand can't be null")
  private String brand;

  @Column(name = "made_in", nullable = false)
  @NotNull(message = "product made in can't be null")
  private String madeIn;

  @Column(name = "price", nullable = false)
  @NotNull(message = "product price can't be null")
  private double price;

  @Column(name = "user_id", nullable = false)
  @NotNull(message = "userId can't be null")
  private int userId;
}
