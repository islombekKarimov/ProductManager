package com.product.entity;

/**
 * Created by Islombek Karimov on 16.04.2020.
 */
public class User {
    private int id;
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

    public User(String name, int id) {

        this.name = name;
        this.id = id;
    }
}
