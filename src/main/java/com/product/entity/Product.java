package com.product.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/** Created by Islombek Karimov on 21.03.2020. */
@Entity(name = "product")
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

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "created_date")
  private LocalDateTime createdDate;

  public Product() {}

  public static Product of() {
    return new Product();
  }

  public String getName() {
    return name;
  }

  public Product setName(String name) {
    this.name = name;
    return this;
  }

  public String getBrand() {
    return brand;
  }

  public Product setBrand(String brand) {
    this.brand = brand;
    return this;
  }

  public String getMadeIn() {
    return madeIn;
  }

  public Product setMadeIn(String madeIn) {
    this.madeIn = madeIn;
    return this;
  }

  public double getPrice() {
    return price;
  }

  public User getUser() {
    return user;
  }

  public Product setUser(User user) {
    this.user = user;
    return this;
  }

  public Product setPrice(double price) {
    this.price = price;
    return this;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public Product setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }
}
