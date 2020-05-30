package com.product.entity;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Islombek Karimov on 16.04.2020.
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, insertable = false)
    private int id;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
