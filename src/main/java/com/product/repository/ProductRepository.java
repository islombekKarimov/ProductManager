package com.product.repository;

import com.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** Created by Islombek Karimov on 21.03.2020. */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByUser(Long id);

  List<Product> findByBrand(String brand);
}
