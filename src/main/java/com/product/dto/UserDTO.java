package com.product.dto;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;

/** Created by Islombek Karimov on 04.07.2020. */
public class UserDTO extends BaseDTO {

  @NotEmpty(message = "Name can not be null!")
  private String name;

  @NotEmpty(message = "Login can not be null!")
  private String login;

  @NotEmpty(message = "Password can not be null!")
  private String password;

  public UserDTO() {}

  public static UserDTO of() {
    return new UserDTO();
  }

  public String getName() {
    return name;
  }

  public UserDTO setName(String name) {
    this.name = name;
    return this;
  }

  public String getLogin() {
    return login;
  }

  public UserDTO setLogin(String login) {
    this.login = login;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserDTO setPassword(String password) {
    this.password = password;
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
    UserDTO dto = (UserDTO) o;
    return Objects.equals(super.getId(), dto.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.getId());
  }
}
