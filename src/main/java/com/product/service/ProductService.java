package com.product.service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public Product getProductById(int id){
       return productRepository.findById(id).get();
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }
}
