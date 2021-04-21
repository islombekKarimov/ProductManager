package com.product.dto;

/**
 * UserDTO.
 *
 * @author Islombek Karimov
 * @since 31.07.2020
 */
public class UserDTO extends BaseDTO {

  private String name;

  private String login;

  private String password;

  private String role;

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

    public String getRole() {
        return role;
    }

    public UserDTO setRole(String role) {
        this.role = role;
        return this;
    }
}
