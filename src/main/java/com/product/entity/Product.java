package com.product.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private int id ;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", madeIn='" + madeIn + '\'' +
                ", price=" + price +
                '}';
    }
}
