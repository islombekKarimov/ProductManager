package com.product.dto;

import javax.validation.constraints.NotEmpty;

/**
 * Created by Islombek Karimov on 05.07.2020.
 */
public class ProductTDO {

    private int id ;
    @NotEmpty(message = "Name can not be null!")
    private String name;
    @NotEmpty(message = "Brand can not be null!")
    private String brand;
    @NotEmpty(message = "Made in can not be null!")
    private String madeIn;
    @NotEmpty(message = "Price can not be null!")
    private double price;
    private int userId;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
