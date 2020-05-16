package com.product.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Islombek Karimov on 16.04.2020.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, insertable = false)
    private int id;

    @Column(name = "name", nullable = false)
    @NotNull(message = "user name can't be null")
    private String name;

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
