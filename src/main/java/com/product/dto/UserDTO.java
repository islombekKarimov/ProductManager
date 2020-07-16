package com.product.dto;


import java.util.Objects;
import javax.validation.constraints.NotEmpty;

/**
 * Created by Islombek Karimov on 04.07.2020.
 */
public class UserDTO {
    private int id;
    @NotEmpty(message = "Name can not be null!")
    private String name;
    @NotEmpty(message = "Login can not be null!")
    private String login;
    @NotEmpty(message = "Password can not be null!")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
