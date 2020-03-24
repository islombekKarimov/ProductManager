package com.product.repository;

import com.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
