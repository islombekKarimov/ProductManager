package com.product.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/** Created by Islombek Karimov on 16.04.2020. */
@Entity(name = "users")
public class User extends BaseEntity {

  @Column(name = "name", nullable = false)
  @NotNull(message = "user name can't be null")
  private String name;

  @Column(name = "login", nullable = false)
  @NotNull(message = "User login can't be null")
  private String login;

  @Column(name = "password", nullable = false)
  @NotNull(message = "User password can't be null")
  @Length(min = 3)
  private String password;

  public User() {}

  public static User of() {
    return new User();
  }

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public String getLogin() {
    return login;
  }

  public User setLogin(String login) {
    this.login = login;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }
}
